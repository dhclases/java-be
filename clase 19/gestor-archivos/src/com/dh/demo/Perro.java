package com.dh.demo;

import java.io.Serializable;

public class Perro implements Serializable {
    private int edad;
    private String nombre;

    public Perro(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public Perro() {
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
