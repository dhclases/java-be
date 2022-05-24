package com.digitalhouse.vacunacion.model;

import java.util.Date;

public class Persona {
    private String nombre;
    private String apellido;
    private String DNI;
    private String nombreVacuna;
    private Date fecha;

    public Persona(String nombre, String apellido, String DNI, String nombreVacuna, Date fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.nombreVacuna = nombreVacuna;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Object[] datos() {
        Object[] informacion;
        informacion = new Object[2];
        informacion[0] = DNI;
        informacion[1] = fecha;
        return informacion;
    }
}
