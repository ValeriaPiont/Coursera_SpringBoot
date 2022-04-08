package com.coursera.student_application.dao.impl;

import com.coursera.student_application.core.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl {

    private final Map<Long, Student> TEMP_STUDENTS = Map.ofEntries(
            Map.entry(1L, new Student("firstname1", "lastname1", "department1")),
            Map.entry(2L, new Student("firstname2", "lastname2", "department1")),
            Map.entry(3L, new Student("firstname3", "lastname3", "department3"))
    );

    public Collection<Student> getAllStudents() {
        return TEMP_STUDENTS.values();
    }

    public Student get(long id) {
        return TEMP_STUDENTS.get(id);
    }

}
