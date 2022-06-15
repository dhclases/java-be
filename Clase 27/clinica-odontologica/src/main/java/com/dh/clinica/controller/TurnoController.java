package com.dh.clinica.controller;

import com.dh.clinica.model.Turno;
import com.dh.clinica.repository.impl.OdontologoDaoH2;
import com.dh.clinica.repository.impl.PacienteDaoH2;
import com.dh.clinica.repository.impl.TurnoListRepository;
import com.dh.clinica.service.OdontologoService;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
    private TurnoService turnoService = new TurnoService(new TurnoListRepository());

    @GetMapping
    public ResponseEntity<List<Turno>> listar(){
        return ResponseEntity.ok(turnoService.listar());
    }


    @PostMapping
    public ResponseEntity<Turno> registrarTurno( @RequestBody Turno turno){
        ResponseEntity<Turno> response;
        if(pacienteService.buscar(turno.getPaciente().getId()) != null
          && odontologoService.buscar(turno.getOdontologo().getId()) != null){
           response = ResponseEntity.ok(turnoService.registrarTurno((turno)));
        }else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

}
