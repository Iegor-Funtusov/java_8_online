package ua.com.alevel;

import ua.com.alevel.annotations.BeanStarter;
import ua.com.alevel.annotations.StartApplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ApplicationStarter {

    public void start(final Map<Class<?>, Object> beanMap) {
        beanMap.values().forEach(bean -> {
            if (bean.getClass().isAnnotationPresent(BeanStarter.class)) {
                Method[] methods = bean.getClass().getDeclaredMethods();
                int size = Stream.of(methods).filter(method -> method.isAnnotationPresent(StartApplication.class)).toList().size();
                if (size == 0) {
                    throw new RuntimeException("annotation StartApplication is not present");
                }
                if (size > 1) {
                    throw new RuntimeException("annotation StartApplication present more 1");
                }
                for (Method method : methods) {
                    if (method.isAnnotationPresent(StartApplication.class)) {
                        try {
                            method.invoke(bean);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
    }
}
