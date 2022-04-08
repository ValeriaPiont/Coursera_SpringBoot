package com.coursera.student_application.controller;

import com.coursera.student_application.core.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class StudentControllerTest {

    private final String URL = "http://localhost:8081/college/student";

    @Test
    void testAddStudent() {
        Student student = new Student("testName1", "testSurname1", "testDepartment");
        student.setStudentId(0L);
        ResponseEntity<String> responseEntity = new RestTemplate()
                .postForEntity(URL,
                        new HttpEntity<>(student),
                        String.class);
        //location example: /college/student/4
        String locationUrl = responseEntity.getHeaders().get("location").get(0);
        System.out.println(locationUrl);
        ResponseEntity<Student> response = new RestTemplate()
                .getForEntity("http://localhost:8081" + locationUrl, Student.class);
        System.out.println(responseEntity.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void testAddStudentShouldThrowException() {
        Student student = new Student(null, "testSurname1", "testDepartment");
        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            ResponseEntity<?> responseEntity = new RestTemplate().postForEntity(URL, new HttpEntity<>(student), Student.class);
            assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        });
    }

    @Test
    void testGetStudent() {
        ResponseEntity<Student> responseEntity =
                new RestTemplate().exchange(URL + "/{id}", HttpMethod.GET, null, Student.class, 3);
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
        System.out.println(responseEntity.getBody());
    }

    @Test
    void testGetAllStudents() {
        ResponseEntity<Collection<Student>> responseEntity =
                new RestTemplate().exchange(URL, HttpMethod.GET, null, new
                        ParameterizedTypeReference<>() {});
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
        responseEntity.getBody().forEach(p-> {
            System.out.println(p);
        });
    }

    @Test
    @DisplayName("Test media type JSON - getSingleStudent() method")
    void testRequestParamJSON(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", MediaType.APPLICATION_JSON_VALUE);
        ResponseEntity<String> responseEntity = new RestTemplate()
                .exchange(URL + "/single?id={id}",
                        HttpMethod.GET,
                        new HttpEntity<String>(headers),
                        String.class,
                        1);
        System.out.println(responseEntity.getBody());
    }

    @Test
    @DisplayName("Test media type XML - getSingleStudent() method")
    void testRequestParamXML(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", MediaType.APPLICATION_XML_VALUE);
        ResponseEntity<String> responseEntity = new RestTemplate()
                .exchange(URL + "/single?id={id}",
                        HttpMethod.GET,
                        new HttpEntity<String>(headers),
                        String.class,
                        1);
        System.out.println(responseEntity.getBody());
    }

}
