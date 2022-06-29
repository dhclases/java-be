package com.dh.institute.service;

import com.dh.institute.model.StudentDTO;

import java.util.Collection;
import java.util.Set;

public interface IStudentService {

    void addStudent(StudentDTO stu);
    StudentDTO getStudentById(Long id);
    void updateStudent(StudentDTO stu);
    void deleteStudentById(Long id);

    Collection<StudentDTO> getAll();
    Set<StudentDTO> getStudentsWithLastnameLike(String lastname);


}
