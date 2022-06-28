package com.dh.mascotas.service;

import com.dh.mascotas.domain.Movimiento;
import com.dh.mascotas.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    @Autowired
    MovimientoRepository movimientoRepository;

    public List<Movimiento> listar(){
        return movimientoRepository.findAll();
    }

    public Optional<Movimiento> save(Movimiento m){
        return Optional.of(movimientoRepository.save(m));
    }

}
