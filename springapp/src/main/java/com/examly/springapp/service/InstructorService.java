package com.examly.springapp.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.examly.springapp.model.Instructor;

public interface InstructorService {

    Instructor addInstructor(Instructor instructor);

    List<Instructor> getAllInstructors();

    Instructor getInstructorById(Long id);

    Instructor updateInstructor(Long id, Instructor instructor);

    void deleteInstructor(Long id);

    Page<Instructor> getInstructorsWithPagination(int page, int size);
    
    // Day 12
    List<Instructor> getInstructorBySpecialization(String specialization);
}
