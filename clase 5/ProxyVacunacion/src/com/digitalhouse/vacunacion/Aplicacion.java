package com.digitalhouse.vacunacion;

import com.digitalhouse.vacunacion.model.Persona;
import com.digitalhouse.vacunacion.registro.Registro;
import com.digitalhouse.vacunacion.registro.RegistroVacunaProxy;

import java.util.Date;

public class Aplicacion {

    public static void main(String[] args) {
        // Definir la entidad persona

        Persona persona = new Persona("Juan","Perez","3534567", "Pfizer", new Date(121,8,3));

        Registro registro = new RegistroVacunaProxy();
        registro.registrar(persona.datos());
    }
}
