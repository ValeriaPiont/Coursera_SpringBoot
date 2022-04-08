package com.coursera.student_application;

import com.coursera.student_application.properties_config.StudentProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
@RequestMapping("/")
@RestController
@Slf4j
@EnableConfigurationProperties(value = StudentProperties.class)
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @GetMapping
    public RedirectView home() {
        log.info("redirected to the URL student/msg");
        return new RedirectView("student/msg");
    }

}
