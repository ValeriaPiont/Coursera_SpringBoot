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

    private Long studentId;

    private String firstName;

    private String surname;

    private String department;

    public Student(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public Student(String firstName, String surname, String department) {
        this.firstName = firstName;
        this.surname = surname;
        this.department = department;
    }
}