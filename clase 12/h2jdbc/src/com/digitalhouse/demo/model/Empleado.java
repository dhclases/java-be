package com.digitalhouse.demo.model;

public class Empleado {
    private int ID;
    private String nombre;
    private int edad;
    private String fecha_inicio;

    private String Empresa;

    public Empleado() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", fecha_inicio='" + fecha_inicio + '\'' +
                ", Empresa='" + Empresa + '\'' +
                '}';
    }
}
