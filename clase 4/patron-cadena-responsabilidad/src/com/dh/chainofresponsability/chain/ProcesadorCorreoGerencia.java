package com.dh.chainofresponsability.chain;

import com.dh.chainofresponsability.chain.ProcesadorCorreo;
import com.dh.chainofresponsability.model.Correo;

public class ProcesadorCorreoGerencia extends ProcesadorCorreo {

    public ProcesadorCorreoGerencia() {
        this.correoAsignado = "gerencia@micolmena.com";
        this.asuntoporProcesar = "gerencia";
    }

    @Override
    public String comprobar(Correo email) {
        String mensaje = "";

        if (this.esValidoElCorreo(email)) {
            mensaje = "Enviando a grencia";
        } else {
            if (this.getSiguiente() != null) {
                mensaje = this.getSiguiente().comprobar(email);
            }
        }
        return mensaje;
    }
}
