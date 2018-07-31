package com.example.springboot.studentservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    private static final String URL = "http://localhost:8081/selectedCourses/";

    public List<String> getCourses(Integer id) {
        RestTemplate template = new RestTemplate();
        String[] courses = template.getForObject(URL + id, String[].class);
        return Arrays.asList(courses);
    }

}
