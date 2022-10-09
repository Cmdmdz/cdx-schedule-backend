package com.cdx.schedulebackend.controller;

import com.cdx.schedulebackend.model.request.CourseRequest;
import com.cdx.schedulebackend.repository.dao.Course;
import com.cdx.schedulebackend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CourseRequest request){
        return courseService.create(request);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @Valid @RequestBody CourseRequest request){
        return courseService.update(id,request);
    }

    @GetMapping("/course")
    public ResponseEntity<?> findAll(){
        return courseService.findAll();
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id){
        return courseService.findCourseById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id){
        return courseService.deleteCourseById(id);
    }
}
