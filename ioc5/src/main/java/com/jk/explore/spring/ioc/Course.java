package com.jk.explore.spring.ioc;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Course {

    private String name;
    private String level;

    public Course(String name, String level) {
        this.name = name;
        this.level = level;
    }


}
