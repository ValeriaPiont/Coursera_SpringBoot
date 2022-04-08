package com.coursera.student_application.service.impl;

import com.coursera.student_application.core.Student;
import com.coursera.student_application.dao.impl.StudentDaoImpl;
import com.coursera.student_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    StudentDaoImpl studentDao;

    @Autowired
    public StudentServiceImpl(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    public Collection<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student get(long id) {
        return studentDao.get(id);
    }
}
