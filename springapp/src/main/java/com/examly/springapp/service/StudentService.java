package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Student;

public interface StudentService {
    
    Student addStudent(Student student);
    
    List<Student> getAllStudents();
    
    Student getStudentById(Long id);
    
    Student updateStudent(Long id, Student student);
    
    // Day 12
    Student getStudentsByEmail(String email);
}
