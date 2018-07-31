package com.example.springboot.studentservice.web;

import com.example.springboot.studentservice.domain.Student;
import com.example.springboot.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping("/student/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @RequestMapping("/courses/{id}")
    public List<String> getStudentGrades(@PathVariable Integer id) {
        return studentService.getStudentCourses(id);
    }
}
