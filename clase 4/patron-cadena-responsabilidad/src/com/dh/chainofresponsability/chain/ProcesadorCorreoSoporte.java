package com.dh.chainofresponsability.chain;

import com.dh.chainofresponsability.model.Correo;

public class ProcesadorCorreoSoporte extends ProcesadorCorreo {

    public ProcesadorCorreoSoporte() {
        this.correoAsignado = "soporteIT@micolmena.com";
        this.asuntoporProcesar = "Soporte";
    }

    @Override
    public String comprobar(Correo email) {
        String mensaje = "";

        if (this.esValidoElCorreo(email)) {
            mensaje = "Enviando a Gerencia";
        } else {
            if (this.getSiguiente() != null) {
                mensaje = this.getSiguiente().comprobar(email);
            }
        }
        return mensaje;
    }
}
