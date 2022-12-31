package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    private static HashMap<String, Student> sDb= new HashMap<>();
    private static HashMap<String, Teacher> tDb = new HashMap<>();
    private static HashMap<String, List<String>> studentTeacherDb=new HashMap<>();



    public void addStudentInDb(Student student) {
        sDb.put(student.getName(),student);
    }

    public void addTeacherInDb(Teacher teacher) {
       tDb.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPairInDb(String student, String teacher) {
       List<String> studentsList = new ArrayList<>();
       if(sDb.containsKey(student) && tDb.containsKey(teacher)){
           if(studentTeacherDb.containsKey(teacher)){
               studentsList = studentTeacherDb.get(teacher);
           }
           studentsList.add(student);
           studentTeacherDb.put(teacher,studentsList);
       }
    }
    public Student getStudentByNameFromDb(String name){
        if(sDb.containsKey(name)){
            return sDb.get(name);
        }else
            return null;
    }
    public Teacher getTeacherByNameFromDb(String name){
        if(tDb.containsKey(name)){
            return tDb.get(name);
        }else
            return null;
    }
    public List<String> getStudentsByTeacherName(String teacher){
        List<String> studentsList = new ArrayList<>();
        if(studentTeacherDb.containsKey(teacher)){
            studentsList = studentTeacherDb.get(teacher);
        }
        return studentsList;
    }
    public List<String> getAllStudentsName(){
        List<String> students = new ArrayList<>();
        for(String student: sDb.keySet()){
            students.add(student);
        }
        return students;
    }
    public void deleteTeacherByName(String teacher){
        List<String> s = new ArrayList<>();
        if(studentTeacherDb.containsKey(teacher)){
            s = studentTeacherDb.get(teacher);
            studentTeacherDb.remove(teacher);
        }
        for(String student: s){
            if(sDb.containsKey(student)){
                sDb.remove(student);
            }
        }
        if(tDb.containsKey(teacher)){
            tDb.remove(teacher);
        }

    }

    public void deleteAllTeachers(){
        for(String teacher: studentTeacherDb.keySet()){
            List<String> students = new ArrayList<>();
            students= studentTeacherDb.get(teacher);

            for(String student : students){
                if(sDb.containsKey(student)){
                    sDb.remove(student);
                }
            }
            tDb.remove(teacher);
        }
        studentTeacherDb = new HashMap<>();
    }

}
