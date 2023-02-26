package com.jk.explore.spring.ioc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Teacher {

    @Autowired
    private ApplicationContext context;
    @Getter
    @Setter
    private List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void addCourses() {
        if(context.containsBean("math")) {
            Course mathCourse = context.getBean("math", Course.class);
            courses.add(mathCourse);
        }
        if(context.containsBean("physics")) {
            Course physicsCourse = context.getBean("physics", Course.class);
        }
    }





}
