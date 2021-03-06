package com.coursera.student_application.service;

import com.coursera.student_application.core.Student;

import java.util.Collection;

public interface StudentService {
    Collection<Student> getAllStudents();
    Student get(long id);
    Collection<Student> getAllStudentsInDepartment(String department, String surname);
    boolean add(Student student);
    boolean isAlreadyExist(Student student);
}
