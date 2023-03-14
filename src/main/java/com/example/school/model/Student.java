package com.example.school.model;

//Student class represents actual data
public class Student{
    private int studentId;//Restricting attributes
    private String studentName;
    private String gender;
    private int standard;

    public Student(int studentId, String studentName, String gender, int standard){ // Intialization of each attribute using constructor
        this.studentId=studentId;
        this.studentName= studentName;
        this.gender= gender;
        this.standard= standard;
    }

    public int getStudentId(){//Getters
        return studentId;
    }

    public void setStudentId(int studentId){
        this.studentId =studentId;
    }

    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String studentName){//Setters
        this.studentName= studentName;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender= gender;
    }

    public int getStandard(){
        return standard;
    }

    public void setStandard(int standard){
        this.standard = standard;
    }
}