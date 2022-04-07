package com.coursera.student_application.controller;

import com.coursera.student_application.core.Student;
import com.coursera.student_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Value("${message}")
    String message;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/msg")
    public String getMassage() {
        return message;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> getAll() {
        return studentService.getAllStudents();
    }

}
