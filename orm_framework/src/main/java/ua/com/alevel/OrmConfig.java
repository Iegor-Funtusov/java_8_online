package ua.com.alevel;

import org.reflections.Reflections;

public class OrmConfig {

    private final Reflections scanner;

    public OrmConfig(Class<?> mainClass) {
        this.scanner = new Reflections(mainClass.getPackageName());
    }

    public Reflections getScanner() {
        return scanner;
    }
}
