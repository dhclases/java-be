package com.dh.taller.demo.controller;

import com.dh.taller.demo.domain.Taller;
import com.dh.taller.demo.service.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Definir un api rest
@RestController
// Se define la ruta base
@RequestMapping("/api/v1")
public class TallerController {
    // Se injecta el servicio
    private final TallerService tallerService;
    @Autowired
    public TallerController(TallerService tallerService) {

        this.tallerService = tallerService;
    }
    // 1er Api rest obtener todos
    @GetMapping("/taller/")
    private List<Taller> listarTalleres(){

        return tallerService.listarTodos();
    }
    // 2do Api rest obtener uno
    @GetMapping("/taller/{id}")
    private Taller obtenerTallerPorId(@PathVariable("id") Long id){

        return tallerService.obtenerPorId(id);
    }

    // En un futuro aqui se colocan los demas, crear, borrar, actualizar
}
