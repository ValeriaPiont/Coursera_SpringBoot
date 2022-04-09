package com.coursera.student_application.controller;

import com.coursera.student_application.core.Student;
import com.coursera.student_application.service.StudentService;
import com.student.core.College;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/colleges")
public class SchoolController {

    private StudentService studentService;

    public SchoolController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ModelAndView getAllSchools(){
        Collection<College> colleges = studentService
                .getAllStudents()
                .stream()
                .map(Student::getCollege)
                .distinct()
                .collect(Collectors.toList());
        log.info("try to add to the model " + Arrays.toString(colleges.toArray()));
        return new ModelAndView("home", "colleges", colleges);
    }

}
