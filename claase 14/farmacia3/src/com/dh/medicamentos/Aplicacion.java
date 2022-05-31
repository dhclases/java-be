package com.dh.medicamentos;

import com.dh.medicamentos.dao.impl.MedicamentoDaoH2;
import com.dh.medicamentos.model.Medicamento;
import com.dh.medicamentos.service.MedicamentoService;
import org.apache.log4j.Logger;

public class Aplicacion {

    final static Logger log = Logger.getLogger(MedicamentoDaoH2.class);

    public static void main(String[] args) {

        // El cliente usa el a traves del servicio los metodos requeridos
        // Se injecta la implemntacion H2 Deseada
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
        // Se define la entidad
        Medicamento medicamento = new Medicamento("Ibuprofeno", "lab123", 1000, 200.0);
        // Se invoca los servicios. En este caso guardamos el medicamento
        medicamentoService.guardar(medicamento);
        // Buscamos el medicamento recien creado
        Medicamento medicina2 = medicamentoService.buscar(1);
        // Detalle de la entidad medicamento
        log.info(medicina2.toString());


 /*
        // ********** Uso de Generico  *********************
        // Inicializar la clase como Entero
        GenericsClass<Integer> miNumero = new GenericsClass<>(5);
        log.info("Generic Class retorna: " + miNumero.getData());

        // Inicializar la clase como String
        GenericsClass<String> miCadena = new GenericsClass<>("Java Programming");
        log.info("Generic Class retorna: " + miCadena.getData());

        // Inicializar la clase como String
        GenericsClass<Medicamento> mimedicamento = new GenericsClass<>(  new Medicamento("Ibuprofeno", "lab123", 1000, 200.0));
        log.info("Generic Class retorna: " + mimedicamento.getData().toString());
*/
    }



}
