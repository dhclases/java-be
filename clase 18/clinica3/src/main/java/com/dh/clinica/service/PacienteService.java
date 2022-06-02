package com.dh.clinica.service;


import com.dh.clinica.dao.impl.DomicilioDaoH2;
import com.dh.clinica.dao.impl.PacienteDaoH2;
import com.dh.clinica.model.Domicilio;
import com.dh.clinica.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class PacienteService {
    final static Logger log = Logger.getLogger(PacienteService.class);
    private PacienteDaoH2 pacienteDaoH2;
    private DomicilioDaoH2 domicilioDaoH2;

    // Se define para la injeccion del de la dependencia
    public PacienteService() {
        this.pacienteDaoH2 = new PacienteDaoH2();
        this.domicilioDaoH2 = new DomicilioDaoH2();

    }

    // Se define los metodos del crud
    public Paciente guardar(Paciente paciente) {
        Paciente pacienteAgregar = pacienteDaoH2.guardar(paciente);
        paciente.getDomicilio().setIdPaciente(pacienteAgregar.getId());
        Domicilio domicilioAgregar = domicilioDaoH2.guardar(pacienteAgregar.getDomicilio());

        pacienteAgregar.setDomicilio(domicilioAgregar);
        return pacienteAgregar;
    }

    public Paciente buscarPorId(Integer id) {
        Paciente pacienteBuscar = pacienteDaoH2.buscarPorId(id);
        Domicilio domicilioBuscar = domicilioDaoH2.buscarPorId(pacienteBuscar.getId());
        pacienteBuscar.setDomicilio(domicilioBuscar);
        return pacienteBuscar;
    }

    public List<Paciente> buscarTodos() {
        return pacienteDaoH2.buscarTodos();
    }

    public void crearTablasDB() {
        try {
            pacienteDaoH2.crearTabla();
            domicilioDaoH2.crearTabla();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    public void eliminarPacientePorId(Integer id) {
        domicilioDaoH2.eliminarPorId(id);
        pacienteDaoH2.eliminarPorId(id);
    }
}
