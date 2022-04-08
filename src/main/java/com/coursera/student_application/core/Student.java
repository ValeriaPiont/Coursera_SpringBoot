package com.coursera.student_application.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Student {

    private String firstname;

    private String surname;

    private String department;

    public Student(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public Student(String firstname, String surname, String department) {
        this.firstname = firstname;
        this.surname = surname;
        this.department = department;
    }
}