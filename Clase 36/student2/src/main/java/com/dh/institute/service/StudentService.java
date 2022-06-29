package com.dh.institute.service;

import com.dh.institute.CommandLineRunnerImpl;
import com.dh.institute.model.Student;
import com.dh.institute.model.StudentDTO;
import com.dh.institute.repository.IStudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService implements IStudentService {
    private static final Logger logger = LogManager.getLogger(CommandLineRunnerImpl.class);

    private final IStudentRepository studentRepository;
    private final ObjectMapper mapper;

    public StudentService(IStudentRepository studentRepository, ObjectMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        saveStudent(studentDTO);
    }

     @Override
    public StudentDTO getStudentById(Long id) {
        Optional<Student> found = studentRepository.findById(id);
        return mapper.convertValue(found, StudentDTO.class);
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {

        saveStudent(studentDTO);
    }

    private void saveStudent(StudentDTO studentDTO) {
        Student newStudent = mapper.convertValue(studentDTO, Student.class);
        studentRepository.save(newStudent);
    }

    @Override
    public void deleteStudentById(Long id) {

        studentRepository.deleteById(id);
    }

    @Override
    public Collection<StudentDTO> getAll() {
        List<Student> allStudents = studentRepository.findAll();
        Set<StudentDTO> allStudentsDTO = new HashSet<>();
        for(Student student: allStudents)
            allStudentsDTO.add(mapper.convertValue(student,StudentDTO.class));

        return allStudentsDTO;
    }

    @Override
    public Set<StudentDTO> getStudentsWithLastnameLike(String lastname) {
        logger.info("Search getStudentsWithLastnameLike. Lastname: {}", lastname);
        Set<Student> allStudents = studentRepository.getStudentByLastnameLike("%" + lastname +"%");
        Set<StudentDTO> allStudentsDTO = new HashSet<>();
        logger.info("Search getStudentsWithLastnameLike. Size: {}", allStudents.size());
        for(Student student: allStudents)
            allStudentsDTO.add(mapper.convertValue(student,StudentDTO.class));
        return allStudentsDTO;
    }
}
