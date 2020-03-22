package com.explore.jk.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

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
    }
}