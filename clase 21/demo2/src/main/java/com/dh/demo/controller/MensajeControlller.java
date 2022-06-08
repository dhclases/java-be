package com.dh.demo.controller;

// Definimos que es un controlador

import com.dh.demo.dominio.Mensaje;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensajeControlller {

    @GetMapping("api/v1/mensajes/")
    private Mensaje obtenerMensaje()  {
        Mensaje msj = new Mensaje();
        msj.setMensaje("Hola digital");
        msj.setTipo("Saludo");

        return msj;
    }

    @GetMapping("api/v2/mensajes/")
    private Mensaje obtenerMensajeV2()  {

        return Mensaje.builder()
                .tipo("Saludo 2")
                .mensaje("Por builder")
                .build();
    }
}
