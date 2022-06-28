package com.example.demo.controller;

import com.example.demo.domain.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    //Ejercicio 1
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Producto producto) {
        productoService.guardar(producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Ejercicio 2
    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping(path = "{id}")
    public Producto obtenerPorId(@PathVariable("id") Long id) {
        return productoService.obtener(id);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> elminarPorId(@PathVariable("id") Long id) {
        productoService.elminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
