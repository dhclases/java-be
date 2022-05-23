package com.dh.chainofresponsability;


import com.dh.chainofresponsability.model.Correo;

public class Main {

    public static void main(String[] args) {

        ValidadorDeCorreos proceso = new ValidadorDeCorreos();
        proceso.comprobar(new Correo("mio@mail.com", "soporte@headingsas.com","reclamo"));
        proceso.comprobar(new Correo("mio@mail.com", "sds@digitalhouse.com","gerencia"));
        proceso.comprobar(new Correo("mio@mail.com", "juan@pepe.com","comercial"));
        proceso.comprobar(new Correo("mio@mail.com", "qqq@digitalhouse.com","reclamo"));

    }

    //TODO: Definir el domain correo DONE
    //TODO: Definir Manejador o Procesador de Correo
    //TODO: Definir Implmentacion Comercial o ProcesadorCorreoComercial
    //TODO: Definir Implmentacion Gerencial o  ProcesadorCorreoGerencial
    //TODO: Definir Implmentacion SoporteITo  ProcesadorCorreoSoporteIT
    //TODO: Probar Implementacion Procesadores
    //TODO: Validador de Correo
    //TODO: Evaluar cliente Validador de Correo Comercial, Gerencail, Soporte y SPAM




}

