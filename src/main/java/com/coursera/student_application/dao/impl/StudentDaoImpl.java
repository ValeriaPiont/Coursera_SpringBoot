package com.coursera.student_application.dao.impl;

import com.coursera.student_application.core.Student;
import com.coursera.student_application.dao.StudentDao;
import com.student.core.College;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class StudentDaoImpl implements StudentDao {

    private Map<Long, Student> TEMP_STUDENTS = new HashMap<>(Map.ofEntries(
            Map.entry(1L, new Student("firstname1", "lastname1", "department1", new College("College", "street", "City", "State"), 123.4)),
            Map.entry(2L, new Student("firstname2", "lastname2", "department1", new College("College1", "street", "City", "State"), 123.4)),
            Map.entry(3L, new Student("firstname3", "lastname3", "department3", new College("College1", "street", "City", "State"), 123.4))
    ));

    @Override
    public Collection<Student> getAllStudents() {
        return TEMP_STUDENTS.values();
    }

    @Override
    public Student get(long id) {
        return TEMP_STUDENTS.get(id);
    }

    @Override
    public void add(Student student) {
        long id = TEMP_STUDENTS.keySet().stream().count();
        ++id;
        student.setStudentId(id);
        log.info("try to add student with ID " + student.getStudentId() + " " + student);
        TEMP_STUDENTS.put(id, student);
    }

    @Override
    public boolean isAlreadyExist(Student student) {
       return TEMP_STUDENTS.containsValue(student);
    }

}
