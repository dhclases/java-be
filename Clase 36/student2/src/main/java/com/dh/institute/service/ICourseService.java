package com.dh.institute.service;

import com.dh.institute.model.CourseDTO;

import java.util.Collection;

public interface ICourseService {

    void addCourse(CourseDTO stu);

    Collection<CourseDTO> getAll();
}
