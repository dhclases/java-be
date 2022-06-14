package com.dh.taller.demo.controller;

import com.dh.taller.demo.domain.Persona;
import com.dh.taller.demo.service.PersonaService;
import com.dh.taller.demo.service.TallerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Definir un api rest
@RestController
// Se define la ruta base
@RequestMapping("/api/v1")
public class PersonaController {
    private final PersonaService personaService;
    private final TallerService  tallerService;

    public PersonaController(PersonaService personaService, TallerService tallerService) {
        this.personaService = personaService;
        this.tallerService = tallerService;
    }


 /*
   private final PersonaJdbcRepository personaJdbcRepository;


    public PersonaController(PersonaJdbcRepository personaJdbcRepository) {
        this.personaJdbcRepository = personaJdbcRepository;
    }

  */

    @GetMapping("/persona/{id}")
    private Persona obtenerPersonaPorId(@PathVariable("id") Long id) {
        System.out.println(tallerService.obtenerPorId(1L).toString());
        return personaService.buscarPorId(id);
    }

}
