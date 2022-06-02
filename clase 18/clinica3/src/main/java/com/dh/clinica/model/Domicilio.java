package com.dh.clinica.model;

public class Domicilio {
    private Integer idDomicilio;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
    private Integer idPaciente;


    public Domicilio() {
    }

    public Domicilio(Integer idDomicilio, String calle, Integer numero, String localidad, String provincia) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio(Integer idDomicilio, String calle, Integer numero, String localidad, String provincia, Integer idPaciente) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
        this.idPaciente = idPaciente;

    }


    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "idDomicilio=" + idDomicilio +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", idPaciente=" + idPaciente +
                '}';
    }
}
