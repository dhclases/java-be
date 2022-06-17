package com.dh.clinica.controller;

import com.dh.clinica.model.Turno;
import com.dh.clinica.repository.impl.OdontologoDaoH2;
import com.dh.clinica.repository.impl.PacienteDaoH2;
import com.dh.clinica.repository.impl.TurnoListRepository;
import com.dh.clinica.service.OdontologoService;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    // Instancias de Servicios

    private TurnoService turnoService = new TurnoService(new TurnoListRepository());
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> response;
        if (!pacienteService.buscar(turno.getPaciente().getId()).isEmpty()
                && !odontologoService.buscar(turno.getOdontologo().getId()).isEmpty()
        ) {
            response = new ResponseEntity<>(turnoService.registrarTurno(turno), HttpStatus.CREATED);
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listar() {
        return ResponseEntity.ok(turnoService.listar());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable Integer id) {
        ResponseEntity<HttpStatus> response;

        if (turnoService.buscar(id).isPresent())
        {
            turnoService.eliminar(id);
            response = ResponseEntity.status( HttpStatus.NO_CONTENT).build();
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> response;
        if (turnoService.buscar(turno.getId()).isPresent())
        {
            response = new ResponseEntity<>(turnoService.actualizar(turno), HttpStatus.OK);
        } else {
            // Es un patron de Builder
            response = ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .build();
        }
        return response;
    }


}
