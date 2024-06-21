package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class Coursecontroller_ResponseEntity {
    private final CourseService courseService;

    public Coursecontroller_ResponseEntity(CourseService service, CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourse(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","V1")
                .header("Operation","Get")
                .body(courseService.getCourses());


    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long id){
        return ResponseEntity
                .ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO){
        return ResponseEntity
                .ok(courseService.createCourse(courseDTO));
    }


}
