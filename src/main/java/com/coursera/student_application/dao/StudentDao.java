package com.coursera.student_application.dao;

import com.coursera.student_application.core.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudents();
    Student get(long id);
    void add(Student student);
    boolean isAlreadyExist(Student student);
}
