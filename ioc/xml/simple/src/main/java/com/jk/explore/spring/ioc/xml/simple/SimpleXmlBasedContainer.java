package com.jk.explore.spring.ioc.xml.simple;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleXmlBasedContainer {

    private ClassPathXmlApplicationContext context;

    public SimpleXmlBasedContainer(String... configLocations) {
        context = new ClassPathXmlApplicationContext(configLocations);
    }

    public ClassPathXmlApplicationContext getContext() {
        return context;
    }

}
