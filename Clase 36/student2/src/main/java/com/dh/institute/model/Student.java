package com.dh.institute.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "Students")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastname;
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<Course> courses;


}
