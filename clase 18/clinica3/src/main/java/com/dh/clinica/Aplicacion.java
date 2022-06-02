package com.dh.clinica;

import com.dh.clinica.dao.impl.PacienteDaoH2;
import com.dh.clinica.model.Domicilio;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.PacienteService;
import org.apache.log4j.Logger;

import java.util.List;

public class Aplicacion {

    final static Logger log = Logger.getLogger(PacienteDaoH2.class);

    public static void main(String[] args) {
        //TODO crear tablas OK
        //TODO FK
        //TODO crear Paciente y Direccion.
        //TODO guardar y buscar un Paciente.


        PacienteService pacienteService = new PacienteService();

        pacienteService.crearTablasDB();

        Domicilio domicilio1 = new Domicilio();
        domicilio1.setCalle("Manuel Ugarte");
        domicilio1.setLocalidad("Belgrano");
        domicilio1.setNumero(2261);
        domicilio1.setProvincia("CABA");

        Paciente paciente1 = new Paciente(domicilio1);
        paciente1.setNombre("Lucas");
        paciente1.setApellido("Marquez");
        paciente1.setFechaIngreso("23/05/2022");
        paciente1.setDni(32658997);


        Paciente p = pacienteService.guardar(paciente1);
        log.info("Paciente 1:");
        log.info(p.toString());

        Paciente p2 = pacienteService.buscarPorId(1);
        log.info(" Resultado de la busqueda de Paciente 1:");
        log.info(p2.toString());

        paciente1.setNombre("Maria");
        paciente1.setDni(1234567);
        paciente1.setFechaIngreso("2/2/1980");

        Paciente p3 = pacienteService.guardar(paciente1);

        log.info("Paciente 2:");
        log.info(p3.toString());

        List<Paciente> pacientes = pacienteService.buscarTodos();

        log.info("*** Listar Empleados");

        pacientes.forEach(o -> log.info(p.toString()));

        log.info("*** Fin Listado");

        //pacienteService.eliminarPacientePorId(1);

    }


}
