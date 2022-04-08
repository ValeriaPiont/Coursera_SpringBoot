package com.coursera.student_application.dao.impl;

import com.coursera.student_application.core.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class StudentDaoImpl {

    public Collection<Student> getAllStudents() {
        return List.of(
                new Student("firstname1", "lastname1"),
                new Student("firstname2", "lastname2")
        );
    }

    public Student get(long id) {
        return new Student("firstname1", "lastname1");
    }

}
