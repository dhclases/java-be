package com.dh.institute.controller;

import com.dh.institute.model.StudentDTO;
import com.dh.institute.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
       return studentService.getStudentById(id);
    }

    @PutMapping()
    public ResponseEntity<HttpStatus> updateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(studentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        ResponseEntity<String> response;

        if (Objects.nonNull(studentService.getStudentById(id))) {
            studentService.deleteStudentById(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping
    public Collection<StudentDTO> listStudents() {
        return studentService.getAll();
    }

    @GetMapping("/getLastnameLike")
    public Set<StudentDTO> listStudentsWithLastnameLike(@RequestParam String lastname) {
        return studentService.getStudentsWithLastnameLike(lastname);
    }

}
