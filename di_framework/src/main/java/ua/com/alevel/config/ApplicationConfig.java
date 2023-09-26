package ua.com.alevel.config;

import org.reflections.Reflections;
import org.reflections.Store;
import ua.com.alevel.annotations.InjectBean;

import java.lang.reflect.Field;
import java.util.Map;

public class ApplicationConfig {

    private final Reflections scanner;

    public ApplicationConfig(Class<?> mainClass) {
        this.scanner = new Reflections(mainClass.getPackageName());
    }

    public void configureBean(final Map<Class<?>, Object> beanMap) {
        beanMap.values().forEach(bean -> {
            Field[] fields = bean.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(InjectBean.class)) {
                    Class<?> fieldType = field.getType();
                    Object injectBean = beanMap.get(fieldType);
                    if (injectBean != null) {
                        field.setAccessible(true);
                        try {
                            field.set(bean, injectBean);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
    }

    public Store getStore() {
        return this.scanner.getStore();
    }
}
