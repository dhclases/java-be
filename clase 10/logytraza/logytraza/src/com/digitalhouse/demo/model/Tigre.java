package com.digitalhouse.demo.model;

import org.apache.log4j.Logger;

public class Tigre {
    private static final Logger logger = Logger.getLogger(Tigre.class);

    private String nombre;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void correr() {
        logger.info("El Tigre esta corriendo");
    }

    public void esMayorA10() throws Exception {
        if (edad > 10) {
            logger.info("El tigre es mayor a 10 años");
        }
        if (edad < 0) {
            logger.error("La edad no puede ser negativa");
            throw new Exception();
        }
    }
}
