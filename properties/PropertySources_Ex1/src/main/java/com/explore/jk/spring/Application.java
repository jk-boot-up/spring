package com.explore.jk.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.util.Iterator;

@ComponentScan(basePackages = "com.explore.jk.spring")
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private Environment env;

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    public static void main(String[] args) {

        var ctx = new AnnotationConfigApplicationContext(Application.class);
        var app = ctx.getBean(Application.class);

        app.run();

        ctx.close();
    }

    private void run() {

        logger.info("From Environment");
        logger.info("Application name: {}", env.getProperty("app.name"));
        logger.info("Application version: {}", env.getProperty("app.version"));

        logger.info("Using @Value injection");
        logger.info("Application name: {}", appName);
        logger.info("Application version: {}", appVersion);
        printResourceProperties(env);

        printNonResourceProperties(env);
    }

    private void printResourceProperties(Environment env) {
        MutablePropertySources propertySources = ((AbstractEnvironment) env).getPropertySources();
        Iterator<PropertySource<?>> sources = (Iterator<PropertySource<?>>) propertySources.iterator();
        while (sources.hasNext()) {
            PropertySource<?> source = sources.next();
            if(source instanceof ResourcePropertySource) {
                logger.info("********************** {} ******************************", source.getName());
                for(String property : ((EnumerablePropertySource<?>) source).getPropertyNames()) {
                    logger.info("{} : {}", property, source.getProperty(property));
                }
            }
        }
    }

    private void printNonResourceProperties(Environment env) {
        MutablePropertySources propertySources = ((AbstractEnvironment) env).getPropertySources();
        Iterator<PropertySource<?>> sources = (Iterator<PropertySource<?>>) propertySources.iterator();
        while (sources.hasNext()) {
            PropertySource<?> source = sources.next();
            if(!(source instanceof ResourcePropertySource)) {
                logger.info("********************** {} ******************************", source.getName());
                for(String property : ((EnumerablePropertySource<?>) source).getPropertyNames()) {
                    logger.info("{} : {}", property, source.getProperty(property));
                }
            }
        }
    }

}