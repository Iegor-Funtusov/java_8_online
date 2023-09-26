package ua.com.alevel;

import ua.com.alevel.config.ApplicationConfig;
import ua.com.alevel.factory.BeanFactory;

public class DIApplication {

    public static void start(Class<?> mainClass) {
        ApplicationConfig applicationConfig = new ApplicationConfig(mainClass);
        BeanFactory beanFactory = new BeanFactory(applicationConfig.getStore());
        beanFactory.initBeans();
        applicationConfig.configureBean(beanFactory.getBeanMap());
        ApplicationStarter applicationStarter = new ApplicationStarter();
        applicationStarter.start(beanFactory.getBeanMap());
    }
}
