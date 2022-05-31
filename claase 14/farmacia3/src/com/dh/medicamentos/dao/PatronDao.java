package com.dh.medicamentos.dao;

public interface PatronDao<T>{

    public T guardar(T t);
    public T buscar(Integer id);
}
