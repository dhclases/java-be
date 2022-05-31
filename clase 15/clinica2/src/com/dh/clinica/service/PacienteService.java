package com.dh.clinica.service;

import com.dh.clinica.dao.PatronDao;
import com.dh.clinica.model.Paciente;

public class PacienteService {

    private PatronDao<Paciente> medicamentoDao;

    // Se define para la injeccion del de la dependencia
    public PacienteService(PatronDao<Paciente> medicamentoDao) {

        this.medicamentoDao = medicamentoDao;
    }
    // Se define los metodos del crud
    public Paciente guardar(Paciente paciente){
       return medicamentoDao.guardar(paciente);

    }

    public Paciente buscar(Integer id){
        return medicamentoDao.buscar(id);
    }
}
