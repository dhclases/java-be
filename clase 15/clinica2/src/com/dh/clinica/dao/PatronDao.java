package com.dh.clinica.dao;

public interface PatronDao<T>{

    public T guardar(T t);
    public T buscar(Integer id);

    public void EliminarPorId(Integer id);
}
