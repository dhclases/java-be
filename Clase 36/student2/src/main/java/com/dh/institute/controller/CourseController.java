package com.dh.institute.controller;

import com.dh.institute.model.CourseDTO;
import com.dh.institute.service.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final ICourseService courseService;
    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> addCourse(@RequestBody CourseDTO course) {
        courseService.addCourse(course);
        return ResponseEntity.ok(HttpStatus.OK);
        // Forma 2:
        // Servicio reporta el nuevo objeto creado
    }
    

    @GetMapping
    public Collection<CourseDTO> listStudents() {
        return courseService.getAll();
    }
}
