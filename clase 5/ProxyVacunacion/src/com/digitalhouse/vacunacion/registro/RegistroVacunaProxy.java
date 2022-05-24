package com.digitalhouse.vacunacion.registro;

import com.digitalhouse.vacunacion.model.Persona;

import java.util.Date;

public class RegistroVacunaProxy implements Registro {
    Persona persona;
    // Preregistro ante de llamar el regitro real
    @Override
    public void registrar(Object[] datos) {
        if(comprobrarFecha( (Date) datos[1])){
            RegistroVacuna registroVacuna = new RegistroVacuna();
            registroVacuna.registrar(datos);
        }
    }

    public boolean comprobrarFecha(Date fecha){
        return fecha.before(new Date());
    }
}
