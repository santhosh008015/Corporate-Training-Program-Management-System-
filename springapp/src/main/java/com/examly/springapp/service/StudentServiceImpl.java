package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepo studentRepo;
    
    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }
    
    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    
    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }
    
    @Override
    public Student updateStudent(Long id, Student student) {
        student.setStudentId(id);
        return studentRepo.save(student);
    }
    
    @Override
    public Student getStudentsByEmail(String email) {
        return studentRepo.findByEmail(email);
    }
}
