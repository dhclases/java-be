package com.dh.taller.demo.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Turno {
    private LocalDate fecha;
    private LocalTime hora;
}
