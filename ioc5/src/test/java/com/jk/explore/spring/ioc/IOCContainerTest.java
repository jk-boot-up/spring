package com.jk.explore.spring.ioc;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class IOCContainerTest
{


    @Test
    public void createIOCContainer() {
        IOCContainer iocContainer = new IOCContainer("classpathxmlapplicationcontext-explore.xml", "classpathxmlapplicationcontext-internationalization.xml");
        Assertions.assertNotNull(iocContainer);
        Assertions.assertEquals(2, iocContainer.getConfigLocationsList().size());
        ApplicationContext context = iocContainer.getContext();
        Assertions.assertTrue(context.containsBean("student"));
        Student student = context.getBean("student", Student.class);
        Assertions.assertTrue(context.containsBean("teacher"));
        Teacher teacher = context.getBean("teacher", Teacher.class);
        Assertions.assertEquals(1, teacher.getCourses().size());
        Assertions.assertTrue(context.containsBean("math"));
        Assertions.assertTrue(context.containsBean("messageSource"));
        MessageSource messageSource = context.getBean("messageSource", MessageSource.class);
        String welcomeMessageEnglish = messageSource.getMessage("welcomeMessage", null, Locale.ENGLISH);
        System.out.println(welcomeMessageEnglish);
        Assertions.assertEquals("hello", welcomeMessageEnglish);
        String welcomeMessageChinese = messageSource.getMessage("welcomeMessage", null, Locale.SIMPLIFIED_CHINESE);
        System.out.println(welcomeMessageChinese);
        Assertions.assertEquals("你好", welcomeMessageChinese);
        for(String name: context.getBeanDefinitionNames()) {
            System.out.println("Bean name:: "+ name);
        };

    }





}
