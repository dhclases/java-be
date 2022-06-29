package com.dh.institute.service;

import com.dh.institute.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    IStudentService studentService;

    @Test
    public void testStudentCreate(){
        StudentDTO student = new StudentDTO();
        student.setLastname("pruebaLastName");
        student.setName("pruebaName");

        studentService.addStudent(student);
        Set<StudentDTO> students = studentService.getStudentsWithLastnameLike("prueba");

        boolean resultado = students.size() > 0;

        assertTrue(resultado);
    }
}