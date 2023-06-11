package com.spring.dog.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationSettings.xml");

        DogService dogService = (DogService) context.getBean("dogService");

        DogDo ddo = (DogDo) context.getBean("dog");
        DogDo ddo2 = (DogDo) context.getBean("dog2");

        dogService.insertDogInfo(ddo);
        dogService.insertDogInfo(ddo2);
    }

}
