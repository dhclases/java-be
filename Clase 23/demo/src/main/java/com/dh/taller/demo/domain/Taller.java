package com.dh.taller.demo.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Taller {
    private Long id;
    private String nombre;
    private String direccion;
}
