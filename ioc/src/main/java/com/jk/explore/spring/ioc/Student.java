package com.jk.explore.spring.ioc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {

    private String name;
    private String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void destroy() {
        System.out.println("Successfully completed the clean up of the Student bean");
    }

}
