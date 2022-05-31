package com.dh.medicamentos;
class GenericsClass<T> {
    // variable del T ipo
    private T data;

    public GenericsClass(T data) {
        this.data = data;
    }

    // metodo que retorna el tipo T
    public T getData() {
        return this.data;
    }
}