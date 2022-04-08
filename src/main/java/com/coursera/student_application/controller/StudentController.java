package com.coursera.student_application.controller;

import com.coursera.student_application.core.Student;
import com.coursera.student_application.properties_config.StudentProperties;
import com.coursera.student_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;
    private StudentProperties studentProperties;

    @Autowired
    public StudentController(StudentService studentService, StudentProperties studentProperties) {
        this.studentService = studentService;
        this.studentProperties = studentProperties;
    }

    @GetMapping("/msg")
    public String getMessage(@RequestHeader("user-agent") String userAgent,
                             @RequestHeader("host") String host,
                             @RequestHeader("accept-language") String acceptLanguage) {
        return studentProperties.getGreeting() + userAgent + host + acceptLanguage;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") long id) {
        return studentService.get(id);
    }

    @GetMapping("/single")
    public Student getSingleStudent(@RequestParam(value = "id") Optional<Long> optional) {
        return studentService.get(optional.orElse(1L));
    }

}
