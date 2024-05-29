package com.mp.restdemo.rest;

import com.mp.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;

    // define @PostConstruct to load the student data
    @PostConstruct
    public void loadData() {
        this.studentList = new ArrayList<>();

        this.studentList.add(new Student("Poornima", "Patel"));
        this.studentList.add(new Student("Mario", "Rossi"));
        this.studentList.add(new Student("Mary", "Smith"));
    }

    // endpoint for "/students" - return list for students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentList;
    }

    // endpoint for "/student/{studentId}" - return student at index
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId < 0 || studentId >= this.studentList.size()) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return this.studentList.get(studentId);
    }
}
