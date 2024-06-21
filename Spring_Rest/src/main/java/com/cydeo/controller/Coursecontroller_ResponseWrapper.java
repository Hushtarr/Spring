package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.entity.Course;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v3")
public class Coursecontroller_ResponseWrapper {
    private final CourseService courseService;

    public Coursecontroller_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper>getAll(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","V1")
                .body(new ResponseWrapper("successful",courseService.getCourses()));
    }

    @PostMapping()
    public ResponseEntity<ResponseWrapper>findCourse(@RequestBody CourseDTO course){
        return ResponseEntity
                .ok( new ResponseWrapper("successful",courseService.createCourse(course)));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper>findCourseById(@PathVariable("id") Long id){
        return ResponseEntity
                .ok(new ResponseWrapper("course id: "+id+" finded",courseService.getCourseById(id)));
    }
}
