package com.example.demo.service;

import com.example.demo.domain.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listar();
    Producto obtener(Long id);
    void guardar(Producto producto);
    void elminar(Long id);
}
