package com.dh.taller.demo;

import java.util.List;

public interface AccionesEntidades<T>{
    List<T> listarTodos();
    T obtenerPorId(Long id);
}
