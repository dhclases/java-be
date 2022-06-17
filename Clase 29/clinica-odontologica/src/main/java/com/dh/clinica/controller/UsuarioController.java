package com.dh.clinica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    // Duda Enviar un
    @GetMapping("/play/")
    public ResponseEntity<String> play1() {
        return new ResponseEntity("Play  1 y status", HttpStatus.CREATED);
    }

    // Duda Enviar un
    @GetMapping("/play2/")
    public ResponseEntity<String> play2(@RequestHeader Map<String, String> headers) {
        // Leer los items del encabezado
        headers.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value));
        });
        final MultiValueMap<String, String> headers2 = new LinkedMultiValueMap<>();
        headers2.add("Authorization", "KLLKLKLLKLK");
        headers2.add("Camada", "La mas curiosa");
        headers2.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);


        return new ResponseEntity<>("Play  2 y status", headers2, HttpStatus.OK);
    }
}
