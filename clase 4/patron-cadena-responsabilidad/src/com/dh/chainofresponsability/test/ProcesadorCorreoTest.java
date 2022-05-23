package com.dh.chainofresponsability.test;

import com.dh.chainofresponsability.chain.*;
import com.dh.chainofresponsability.model.Correo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProcesadorCorreoTest {
    ProcesadorCorreo procesadorPrueba;

    @BeforeAll
    public void init() {
        // Crear los pasos de la cadena
        this.procesadorPrueba = new ProcesadorCorreoComercial();
        ProcesadorCorreo tecnica = new ProcesadorCorreoSoporte();
        ProcesadorCorreo comercial = new ProcesadorCorreoGerencia();
        ProcesadorCorreo spam = new ProcesadorCorreoSpam();

        // Interconectamos
        procesadorPrueba.setSiguiente(comercial);
        comercial.setSiguiente(tecnica);
        tecnica.setSiguiente(spam);
    }

    @Test
    void comprobar_deberíaRetornarUnMensajeIndicandoQueElCorreoEsDeGerencia() {
        //DADO
        Correo correo = new Correo("mio@mail.com", "sds@digitalhouse.com", "gerencia");
        String mensajeEsperado = "Enviando a Gerencia";

        //CUANDO
        String mensajeObtenido = procesadorPrueba.comprobar(correo);

        //ENTONCES
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }


}