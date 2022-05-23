package com.dh.chainofresponsability;

import com.dh.chainofresponsability.chain.*;
import com.dh.chainofresponsability.model.Correo;

public class ValidadorDeCorreos
{
    private ProcesadorCorreo procesadorEstadoInicial;
    private final String MENSAJE_SPAM = "¡Ojo! Marcado como spam....";

    public ValidadorDeCorreos() {
        // Configuramos los eslabones de la cadena
        this.procesadorEstadoInicial = new ProcesadorCorreoComercial();
        ProcesadorCorreo tecnica = new ProcesadorCorreoSoporte();
        ProcesadorCorreo comercial = new ProcesadorCorreoComercial();
        ProcesadorCorreo spam = new ProcesadorCorreoSpam();

        // Interconectamos
        procesadorEstadoInicial.setSiguiente(comercial);
        comercial.setSiguiente(tecnica);
        tecnica.setSiguiente(spam);
    }

    public boolean comprobar(Correo email) {
        boolean result = !MENSAJE_SPAM.equalsIgnoreCase(procesadorEstadoInicial.comprobar(email));
        System.out.printf("Procesando: %s No es Spam: %s \n ", email.getAsunto(), result);

        return result;
    }
}


