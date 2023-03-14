package com.example.school.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.example.school.service.StudentH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.school.model.Student;

@RestController //Controller class handles HTTP requests
public class StudentController{

    @Autowired //injecting dependencies
    private StudentH2Service studentService;

    //Requesting method for specific path
    @GetMapping("/students")
    public ArrayList<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/students/bulk")//when we are adding bulk of students, we use this method 
    public String addStudentsBulk(@RequestBody ArrayList<Student> student){
        return studentService.addStudentsBulk(student);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable ("studentId") int studentId, @RequestBody Student student){
        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId){
        studentService.deleteStudent(studentId);
    }
    
}