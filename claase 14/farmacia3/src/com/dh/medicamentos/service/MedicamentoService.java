package com.dh.medicamentos.service;

import com.dh.medicamentos.dao.PatronDao;
import com.dh.medicamentos.model.Medicamento;

public class MedicamentoService {

    private PatronDao<Medicamento> medicamentoDao;

    // Se define para la injeccion del de la dependencia
    public MedicamentoService(PatronDao<Medicamento> medicamentoDao) {

        this.medicamentoDao = medicamentoDao;
    }
    // Se define los metodos del crud
    public Medicamento guardar(Medicamento medicamento){
       return medicamentoDao.guardar(medicamento);

    }

    public  Medicamento buscar(Integer id){
        return medicamentoDao.buscar(id);
    }
}
