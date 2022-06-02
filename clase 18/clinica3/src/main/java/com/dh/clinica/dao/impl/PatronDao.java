package com.dh.clinica.dao.impl;

public interface PatronDao<T> {
    public T guardar(T t);

    public T buscarPorId(Integer id);

    public void eliminarPorId(Integer id);

}
