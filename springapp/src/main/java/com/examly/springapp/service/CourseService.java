package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Course;

public interface CourseService {

    Course addCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course updateCourse(Long id, Course course);

    // Day 11
    List<Course> getCoursesByInstructor(Long instructorId);
    
    // Day 12
    List<Course> getCoursesByLevel(String level);
}
