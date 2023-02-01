package com.springlearning.spring;

import com.springlearning.service.AppConfig;

import java.net.URL;

public class ApplicationContext {

    private Class configClass;
    public ApplicationContext(Class<AppConfig> appConfigClass) {
        this.configClass = appConfigClass;

        // 扫描
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScan = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String scanPath = componentScan.value();
            System.out.printf("path: ");
            System.out.println(scanPath);

            ClassLoader classLoader = appConfigClass.getClassLoader();
            URL url = classLoader.getResource(scanPath);
            System.out.println(url);
        }
    }

    public Object getBean(String beanName) {
        return null;
    }
}
