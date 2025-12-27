package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    // Day 11
    List<Course> findByInstructor_InstructorId(Long instructorId);
    
    // Day 12
    List<Course> findByLevel(String level);
}
