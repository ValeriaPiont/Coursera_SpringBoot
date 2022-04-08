package com.coursera.student_application.controller;

import com.coursera.student_application.core.Student;
import com.coursera.student_application.properties_config.StudentProperties;
import com.coursera.student_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping(path = "/single", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Student> getSingleStudent(@RequestParam("id") Optional<Long> optional) {
        return ResponseEntity.ok(studentService.get(optional.orElse(0L)));
    }

    @GetMapping("/search/{department}")
    public Collection<Student> getAllStudentsInDepartment(@PathVariable("department") String department, @RequestParam("surname") Optional<String> optional) {
        return studentService.getAllStudentsInDepartment(department, optional.orElse(""));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        boolean isAdded = studentService.add(student);
        if(isAdded) {
            URI uri = URI.create("/college/student/" + student.getStudentId());
            return ResponseEntity.accepted().location(uri).body(student);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
