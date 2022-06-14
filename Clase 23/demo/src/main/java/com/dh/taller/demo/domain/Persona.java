package com.dh.taller.demo.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Persona {
    private Integer id;
    private String nombre;
    private String dni;
}
