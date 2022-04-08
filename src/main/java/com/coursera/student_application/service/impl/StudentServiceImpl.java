package com.coursera.student_application.service.impl;

import com.coursera.student_application.core.Student;
import com.coursera.student_application.dao.impl.StudentDaoImpl;
import com.coursera.student_application.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
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

    @Override
    public Collection<Student> getAllStudentsInDepartment(String department, String surname) {
        return studentDao.getAllStudents()
                .stream()
                .filter(p -> p.getDepartment().equals(department))
                .filter(p -> p.getSurname().contains(surname))
                .collect(Collectors.toList());
    }

    @Override
    public boolean add(Student student) {
        if (student.getFirstName() != null && student.getSurname() != null
                && student.getDepartment() != null) {
            if (!isAlreadyExist(student)) {
                studentDao.add(student);
                log.info("student was added");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAlreadyExist(Student student) {
        return studentDao.isAlreadyExist(student);
    }

}
