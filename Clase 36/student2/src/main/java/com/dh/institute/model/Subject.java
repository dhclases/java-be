package com.dh.institute.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Subjects")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue
    Long id;

    String name;
    String leader;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private Set<Course> courses;
}
