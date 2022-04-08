package com.coursera.student_application.properties_config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "student")
@Setter
@Getter
@Component
public class StudentProperties {
    private String greeting;
}
