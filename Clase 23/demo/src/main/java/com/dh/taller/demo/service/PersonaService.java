package com.dh.taller.demo.service;

import com.dh.taller.demo.domain.Persona;
import com.dh.taller.demo.repository.PersonaJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    PersonaJdbcRepository personaJdbcRepository;

    public Persona buscarPorId(long id){
        return personaJdbcRepository.buscarPorId(id);
    }
}
