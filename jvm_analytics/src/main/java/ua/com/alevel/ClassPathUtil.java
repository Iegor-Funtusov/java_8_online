package ua.com.alevel;

import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public final class ClassPathUtil {

    private ClassPathUtil() { }

    public static Map<String, List<String>> getAllMapClassesByClassPath(String[] classPath) {
        Map<String, List<String>> map = new HashMap<>();
        List<File> files = getClassLocationByClassPath(classPath);
        for (File file : files) {
            if (file.isDirectory()) {
                map.putAll(getClassesFromDirectory(file));
            } else {
                map.put(file.getName(), getClassesFromJar(file));
            }
        }
        return map;
    }

    private static List<File> getClassLocationByClassPath(String[] classPath) {
        return Arrays.stream(classPath).map(File::new).toList();
    }

    private static Map<String, List<String>> getClassesFromDirectory(File path) {
        Map<String, List<String>> map = new HashMap<>();
        List<File> classFiles = listFiles(path, (dir, name) -> name.endsWith(".class"), true);
        if (CollectionUtils.isNotEmpty(classFiles)) {
            int index = path.getAbsolutePath().length() + 1;
            String mainPackage = classFiles
                    .stream()
                    .map(classFile -> classFile.getAbsolutePath().substring(index))
                    .map(ClassPathUtil::fromFileToClassName)
                    .map(ClassPathUtil::getPackageByClassName)
                    .collect(Collectors.toCollection(TreeSet::new))
                    .first();

            List<String> classes = classFiles
                    .stream()
                    .map(classFile -> classFile.getAbsolutePath().substring(index))
                    .map(ClassPathUtil::fromFileToClassName)
                    .toList();
            map.put(mainPackage, classes);
        }
        return map;
    }

    private static List<String> getClassesFromJar(File path) {
        List<String> list = new ArrayList<>();
        if (path.canRead()) {
            try(JarFile jar = new JarFile(path)) {
                Enumeration<JarEntry> entries = jar.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = entries.nextElement();
                    if (jarEntry.getName().endsWith("class")) {
                        String className = fromFileToClassName(jarEntry.getName());
                        list.add(className);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    private static List<File> listFiles(File directory, FilenameFilter filter, boolean recurse) {
        List<File> files = new ArrayList<>();
        File[] items = directory.listFiles();
        if (items != null) {
            for (File item : items) {
                if (filter == null || filter.accept(directory, item.getName())) {
                    files.add(item);
                }
                if (recurse && directory.isDirectory()) {
                    files.addAll(listFiles(item, filter, recurse));
                }
            }
        }
        return files;
    }

    private static String fromFileToClassName(String fileName) {
        return fileName
                .substring(0, fileName.length() - 6)
                .replaceAll("/|\\\\", "\\.");
    }

    private static String getPackageByClassName(String className) {
        return className.substring(0, className.lastIndexOf("."));
    }
}
