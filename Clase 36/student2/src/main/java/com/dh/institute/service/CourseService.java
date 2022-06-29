package com.dh.institute.service;

import com.dh.institute.model.Course;
import com.dh.institute.model.CourseDTO;
import com.dh.institute.repository.ICourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CourseService implements ICourseService {


    private final ICourseRepository courseRepository;
    private final ObjectMapper mapper;

    public CourseService(ICourseRepository courseRepository, ObjectMapper mapper) {
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    @Override
    public void addCourse(CourseDTO courseDTO) {
        Course newCourse = mapper.convertValue(courseDTO, Course.class);
        courseRepository.save(newCourse);
    }

    @Override
    public Collection<CourseDTO> getAll() {
        List<Course> allCourses = courseRepository.findAll();
        Set<CourseDTO> allCoursesDTO = new HashSet<>();
        for (Course course : allCourses)
            allCoursesDTO.add(mapper.convertValue(course, CourseDTO.class));

        return allCoursesDTO;
    }
}
