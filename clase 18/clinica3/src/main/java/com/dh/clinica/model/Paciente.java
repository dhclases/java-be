package com.dh.clinica.model;

public class Paciente {
    private Integer id;
    private String nombres;
    private String apellidos;
    private Integer dni;


    private Domicilio domicilio;

    private String fechaIngreso;


    public Paciente() {
        this.domicilio = new Domicilio();
    }

    public Paciente(Domicilio domicilio) {
        this.domicilio = domicilio;
    }


    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellidos;
    }

    public void setApellido(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni=" + dni +
                ", domicilio=" + domicilio +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                '}';
    }
}
