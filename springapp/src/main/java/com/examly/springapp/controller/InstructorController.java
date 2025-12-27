package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> addInstructor(
            @RequestBody(required = false) Instructor instructor) {

        if (instructor == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                instructorService.addInstructor(instructor),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {

        List<Instructor> list = instructorService.getAllInstructors();

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {

        Instructor instructor = instructorService.getInstructorById(id);

        if (instructor == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(
            @PathVariable Long id,
            @RequestBody Instructor instructor) {

        return new ResponseEntity<>(
                instructorService.updateInstructor(id, instructor),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // -------- DAY 9 --------
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<Instructor>> getInstructorsWithPagination(
            @PathVariable int page,
            @PathVariable int size) {

        Page<Instructor> pageResult =
                instructorService.getInstructorsWithPagination(page, size);

        return new ResponseEntity<>(pageResult, HttpStatus.OK);
    }

    // -------- DAY 12 FIX --------
    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<?> getInstructorBySpecialization(
            @PathVariable String specialization) {

        List<Instructor> instructors =
                instructorService.getInstructorBySpecialization(specialization);

        if (instructors == null || instructors.isEmpty()) {
            return new ResponseEntity<>(
                    "No instructors found with specialization: " + specialization,
                    HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

}