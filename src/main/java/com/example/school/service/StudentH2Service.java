//Implementing business logic in service class
package com.example.school.service;

import com.example.school.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.*;
import com.example.school.model.Student;
import com.example.school.model.StudentRowMapper;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service //Marks as service class provider
public class StudentH2Service implements StudentRepository{

    @Autowired
    public JdbcTemplate db;//Jdbc perform CRUD operations


    @Override//Overriding the abstract method and implementing
    public ArrayList<Student> getStudents(){
        List<Student> studentsList = db.query("select * from STUDENT", new StudentRowMapper());
        ArrayList<Student> students = new ArrayList<>(studentsList);
        return students;
    }

    @Override
    public Student getStudentById(int studentId){
        try{
        Student student = db.queryForObject("select * from STUDENT where studentId=?", new StudentRowMapper(), studentId);
        return student;
        }
        catch(Exception e){ //Handling exceptions
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public Student addStudent(Student student){
        db.update("insert into STUDENT(studentName, gender, standard) values(?, ?, ?)", student.getStudentName(), student.getGender(), student.getStandard());
        Student student1 = db.queryForObject("select * from STUDENT where studentName=? and gender=? and standard=?", new StudentRowMapper(), student.getStudentName(), student.getGender(), student.getStandard());
        return student1;
    }
    
    @Override
    public String addStudentsBulk(ArrayList<Student> student){
        int count=0;
        for (Student student1:student){
        db.update("insert into STUDENT(studentName, gender, standard) values(?, ?, ?)",student1.getStudentName(), student1.getGender(), student1.getStandard());
        count+=1;
        }
        return String.format("Successfully added %d students",count); 
    }
    
    @Override
    public Student updateStudent(int studentId, Student student){
        Student student1 = db.queryForObject("select * from STUDENT where studentId=?", new StudentRowMapper(), studentId);
        if (student1==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
        if(student.getStudentName()!=null){
            db.update("update STUDENT set studentName=? where studentId=?", student.getStudentName(), studentId);
        }
        if(student.getGender()!=null){
            db.update("update STUDENT set gender=? where studentId=?", student.getGender(), studentId);
        }
        if(student.getStandard()!=0){
            db.update("update STUDENT set standard=? where studentId=?", student.getStandard(), studentId);
        }
        return getStudentById(studentId);
    }

    @Override
    public void deleteStudent(int studentId){
        
            db.update("delete from STUDENT where studentId=?", studentId);
            
    }
}