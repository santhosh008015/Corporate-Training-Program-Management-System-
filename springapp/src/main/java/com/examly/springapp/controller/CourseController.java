package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Course;
import com.examly.springapp.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // -------- DAY 10 --------

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course saved = courseService.addCourse(course);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> list = courseService.getAllCourses();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable Long id,
            @RequestBody Course course) {

        Course updated = courseService.updateCourse(id, course);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // -------- DAY 11 --------

    @GetMapping("/instructor/{id}")
    public ResponseEntity<List<Course>> getCoursesByInstructor(
            @PathVariable Long id) {

        List<Course> courses = courseService.getCoursesByInstructor(id);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    // -------- DAY 12 (FIX) --------

    @GetMapping("/level/{level}")
    public ResponseEntity<?> getCoursesByLevel(@PathVariable String level) {

        List<Course> courses = courseService.getCoursesByLevel(level);

        if (courses == null || courses.isEmpty()) {
            return new ResponseEntity<>(
                    "No courses found at level: " + level,
                    HttpStatus.NO_CONTENT
         );
        }

        return new ResponseEntity<>(courses, HttpStatus.OK);
}

}
