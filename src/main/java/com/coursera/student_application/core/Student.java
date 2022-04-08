package com.coursera.student_application.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

@Component
@NoArgsConstructor
@ToString
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement //Maps a class to an XML element.
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