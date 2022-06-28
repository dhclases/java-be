package com.dh.mascotas.domain;

import lombok.*;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity // Jpa
@Getter // lombok
@Setter // lombok
@NoArgsConstructor // lombok
@AllArgsConstructor // lombok
@Builder // lombok
@Table(name="tbl_movimiento") // Definir nombre de la tabla destino
public class Movimiento {
    @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "movimiento_sequence", sequenceName = "movimiento_sequence", initialValue = 20 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimiento_sequence")
    private Integer id;
    @Column
    private String descripcion;
    @Column
    private String monto;

}
