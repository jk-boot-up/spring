package com.jk.explore.spring.ioc;


import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class IOCContainer
{

   @Getter
   private List<String> configLocationsList = new ArrayList<>();

   @Getter
   private ApplicationContext context;

   public IOCContainer(String ... configLocations) {
       for(int i=0; i < configLocations.length; i++) {
           configLocationsList.add(configLocations[i]);
       }
       context = new ClassPathXmlApplicationContext(configLocations);
   }



}
