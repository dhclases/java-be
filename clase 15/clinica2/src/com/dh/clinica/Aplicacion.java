package com.dh.clinica;

import com.dh.clinica.dao.impl.PacienteDaoH2;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.PacienteService;
import org.apache.log4j.Logger;

public class Aplicacion {

    final static Logger log = Logger.getLogger(PacienteDaoH2.class);

    public static void main(String[] args) {

        // El cliente usa el a traves del servicio los metodos requeridos
        // Se injecta la implemntacion H2 Deseada
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
        // Se define la entidad
        Paciente paciente = new Paciente("Ibuprofeno", "lab123", 1000, 200.0);
        // Se invoca los servicios. En este caso guardamos el medicamento
        pacienteService.guardar(paciente);
        // Buscamos el medicamento recien creado
        Paciente medicina2 = pacienteService.buscar(1);
        // Detalle de la entidad medicamento
        log.info(medicina2.toString());



    }



}
