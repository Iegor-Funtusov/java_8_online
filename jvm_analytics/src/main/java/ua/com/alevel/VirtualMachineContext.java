package ua.com.alevel;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class VirtualMachineContext {

    private String displayName;
    private String pid;
    private String providerType;
    private String providerName;
    private Map<String, String> agentProperties;
    private Map<String, String> systemProperties;
    private String[] classPathList;
}
