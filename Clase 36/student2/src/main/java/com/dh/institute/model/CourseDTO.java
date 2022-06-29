package com.dh.institute.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {

    private Long id;
    private int nota;
    private Student student;
    private Subject subject;
}
