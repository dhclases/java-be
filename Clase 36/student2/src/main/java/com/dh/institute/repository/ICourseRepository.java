package com.dh.institute.repository;

import com.dh.institute.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Long> {

}
