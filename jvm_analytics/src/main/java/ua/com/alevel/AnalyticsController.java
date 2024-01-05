package ua.com.alevel;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/analytics")
public class AnalyticsController {

    private static final String JAVA_CLASS_PATH = "java.class.path";

    @GetMapping
    public String getMainInfo(Model model) {
        List<VirtualMachineDescriptor> descriptors = VirtualMachine.list();
        VirtualMachineDescriptor descriptor = descriptors
                .stream()
                .filter(desc ->
                        desc.displayName().startsWith("ua.com.alevel.FinalProjectServerApplication")
                                || desc.displayName().startsWith("target/final_project_server-0.0.1-SNAPSHOT.jar"))
                .findFirst().orElseThrow(() -> new RuntimeException("descriptor not found"));
        try {
            VirtualMachine vm = VirtualMachine.attach(descriptor);
            var context = new VirtualMachineContext();
            context.setProviderType(vm.provider().type());
            context.setProviderName(vm.provider().name());
            context.setPid(descriptor.id());
            context.setDisplayName(descriptor.displayName());
            context.setAgentProperties(streamConvert(vm.getAgentProperties()));

            Properties systemProperties = vm.getSystemProperties();
            Set<String> propertyNames = systemProperties
                    .stringPropertyNames()
                    .stream()
                    .filter(property -> !property.equals(JAVA_CLASS_PATH))
                    .collect(Collectors.toSet());
            Properties newSystemProperties = new Properties();
            for (String propertyName : propertyNames) {
                newSystemProperties.put(propertyName, systemProperties.get(propertyName));
            }
            String classPath = systemProperties.getProperty(JAVA_CLASS_PATH);
            String[] paths = classPath.split(File.pathSeparator);
            context.setClassPathList(paths);

            context.setSystemProperties(streamConvert(newSystemProperties));
            model.addAttribute("context", context);
        } catch (AttachNotSupportedException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return "pages/analytics";
    }

    @GetMapping("/classes")
    public String getAllClassesByVM(Model model, @RequestParam String pidId) {

        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        System.out.println("heapMemoryUsage = " + heapMemoryUsage);

        try {
            VirtualMachine vm = VirtualMachine.attach(pidId);
            String classPath = vm.getSystemProperties().getProperty(JAVA_CLASS_PATH);
            String[] paths = classPath.split(File.pathSeparator);
            Map<String, List<String>> classPathMap = ClassPathUtil.getAllMapClassesByClassPath(paths);
            model.addAttribute("classPathMap", classPathMap);
        } catch (AttachNotSupportedException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return "pages/classes";
    }

    private Map<String, String> streamConvert(Properties prop) {
        return prop.entrySet().stream().collect(
                Collectors.toMap(
                        e -> String.valueOf(e.getKey()),
                        e -> String.valueOf(e.getValue()),
                        (prev, next) -> next, HashMap::new
                ));
    }
}
