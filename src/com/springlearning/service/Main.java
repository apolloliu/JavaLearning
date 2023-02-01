package com.springlearning.service;

import com.springlearning.spring.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ApplicationContext appContext = new ApplicationContext(AppConfig.class);
        UserService userService = (UserService) appContext.getBean("userService");
//        UserService userService = (UserService) appContext.getBean(UserService.class);
    }
}
