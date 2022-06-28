package com.dh.mascotas.controller;


import com.dh.mascotas.domain.Movimiento;
import com.dh.mascotas.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    MovimientoService movService;

    @PostMapping
    public ResponseEntity<String> guardar(@RequestBody Movimiento m){
        ResponseEntity<String> respuesta;
        if(movService.save(m).isPresent()){
            respuesta = ResponseEntity.ok("El movimiento fue registrado");
        }else {
            respuesta = ResponseEntity.internalServerError().body("Error de sistema contacta al admino");
        }
        return respuesta;
    }

    @GetMapping
    public ResponseEntity<List<Movimiento>> listar(){
        return ResponseEntity.ok(movService.listar());
    }

}
