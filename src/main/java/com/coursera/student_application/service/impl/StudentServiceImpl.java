package com.coursera.student_application.service.impl;

import com.coursera.student_application.core.Student;
import com.coursera.student_application.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    public Collection<Student> getAllStudents() {
        return List.of(
                new Student("firstname1", "lastname1"),
                new Student("firstname2", "lastname2")
        );
    }
}
