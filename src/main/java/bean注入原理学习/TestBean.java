package bean注入原理学习;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.Annotation;

@SpringBootApplication
public class TestBean implements SpringBootApplication {
    @Autowired
    BeanFactory beanFactory;

    public void run() throws Exception {} {
        beanFactory.printBean();
    }

    @Override
    public Class<?>[] exclude() {
        return new Class[0];
    }

    @Override
    public String[] excludeName() {
        return new String[0];
    }

    @Override
    public String[] scanBasePackages() {
        return new String[0];
    }

    @Override
    public Class<?>[] scanBasePackageClasses() {
        return new Class[0];
    }

    @Override
    public Class<? extends BeanNameGenerator> nameGenerator() {
        return null;
    }

    @Override
    public boolean proxyBeanMethods() {
        return false;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
