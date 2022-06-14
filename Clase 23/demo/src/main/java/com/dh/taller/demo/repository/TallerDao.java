package com.dh.taller.demo.repository;

import com.dh.taller.demo.AccionesEntidades;
import com.dh.taller.demo.domain.Taller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
// A los fines del se simula una persistencia
// Esto sera sustuido por jpa
@Component
public class TallerDao implements AccionesEntidades<Taller> {
    public static List<Taller> talleres;

    @Autowired
    public TallerDao() {
        talleres = new ArrayList<>();
        talleres.add(Taller.builder().id(1L).nombre("Taller Principal").direccion("Medrano").build());
        talleres.add(Taller.builder().id(2L).nombre("Taller Secundario").direccion("Palermo").build());
        talleres.add(Taller.builder().id(3L).nombre("Taller Lavado").direccion("Almagro").build());
    }

    @Override
    public List<Taller> listarTodos() {
        return talleres;
    }

    @Override
    public Taller obtenerPorId(Long id) {
        return TallerDao.talleres.stream()
                .filter(o -> o.getId().equals(id))
                .toList()
                .get(0);
    }

}
