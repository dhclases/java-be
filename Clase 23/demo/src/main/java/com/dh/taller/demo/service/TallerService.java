package com.dh.taller.demo.service;

import com.dh.taller.demo.AccionesEntidades;
import com.dh.taller.demo.domain.Taller;
import com.dh.taller.demo.repository.TallerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// Se define la clase como servicio para luego se inyectada
@Service
public class TallerService implements AccionesEntidades<Taller> {
    // Se inicializa el el dato. Esta forma es menos recomendada
    @Autowired
    TallerDao tallerDao;


    // Se llama al a los diferentes dao o repositorios
    @Override
    public List<Taller> listarTodos() {
        return tallerDao.listarTodos();
    }

    @Override
    public Taller obtenerPorId(Long id) {
        return tallerDao.obtenerPorId(id);
    }
}
