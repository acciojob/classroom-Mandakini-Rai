package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public  void addStudent(Student student){
        studentRepository.addStudentInDb(student);
    }
    public  void addTeacher(Teacher teacher){
        studentRepository.addTeacherInDb(teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        studentRepository.addStudentTeacherPairInDb(student,teacher);
    }
    public Student getStudentByName(String name){
        Student s = studentRepository.getStudentByNameFromDb(name);
        return s;
    }
    public Teacher getTeacherByName(String name){
        Teacher t = studentRepository.getTeacherByNameFromDb(name);
        return t;
    }
    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepository.getStudentsByTeacherName(teacher);
    }
    public List<String> getAllStudentsName(){
        return studentRepository.getAllStudentsName();
    }
    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacherByName(teacher);
    }
    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
