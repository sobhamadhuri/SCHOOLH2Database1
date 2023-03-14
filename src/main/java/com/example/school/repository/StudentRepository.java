//Implementing interface for consistency and abstraction
package com.example.school.repository;

import java.util.*;
import com.example.school.model.Student;

public interface StudentRepository{
    ArrayList<Student> getStudents();//Declaring abstract methods
    Student getStudentById(int studentId);

    String addStudentsBulk(ArrayList<Student> student);
    Student addStudent(Student student);
    Student updateStudent(int studentId, Student student);
    void deleteStudent(int studentId);

}