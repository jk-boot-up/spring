package com.explore.jk.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration//,override.properties
@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
@PropertySource(value = "override.properties", ignoreResourceNotFound = true)
public class AppConfig {

}