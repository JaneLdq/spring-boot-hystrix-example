package com.example.springboot.studentservice.service;

import com.example.springboot.studentservice.domain.Student;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private CourseService courseService;

    private static List<Student> students = Arrays.asList(
            new Student(1, "Jane"),
            new Student(2, "Jerry"),
            new Student(3, "Lay"),
            new Student(4, "Tony"),
            new Student(5, "Bob"),
            new Student(6, "Henry")
    );

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(Integer id) {
        if (id <= students.size()) {
            return students.get(id);
        }
        return new Student(-1, "No Such Student");
    }

    @HystrixCommand(fallbackMethod = "defaultCourses", commandProperties = {
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="30000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="5")
    })
    public List<String> getStudentCourses(Integer id) {
        return courseService.getCourses(id);
    }

    private List<String> defaultCourses(Integer id) {
        return Arrays.asList("Default Course");
    }

}
