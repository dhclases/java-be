package com.dh.profesor.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@Entity
public class Profesor {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String titulo;

    @OneToMany( mappedBy = "profesor", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos = new HashSet<>();
}
