package com.example.springboot.courseservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    private static final List<List<String>> courseList = new ArrayList<>();

    static {
        courseList.add(Arrays.asList("Machine Learning", "Algorithms"));
        courseList.add(Arrays.asList("Database", "Big Data", "Python"));
        courseList.add(Arrays.asList("User Experience"));
        courseList.add(Arrays.asList("Computer Vision", "Internet of Things"));
    }

    @RequestMapping("/selectedCourses/{studentId}")
    public List<String> getCoursesByStudentId(@PathVariable Integer studentId) {
        return courseList.get(studentId);
    }
}
