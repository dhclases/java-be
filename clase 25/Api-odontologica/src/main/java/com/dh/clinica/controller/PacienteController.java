package com.dh.clinica.controller;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.repository.impl.PacienteDaoH2;
import com.dh.clinica.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    // Instancias si unilizar @Autowire y  @Service
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @GetMapping()
    public ResponseEntity<List<Paciente>> listarPacientes(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }
    // Get usando ResponseEntity Obtener Todos los Pacientes

    // Pos con ResponseEntity Crear Paciente

    @PostMapping
    public ResponseEntity<Paciente> guadarPaciente( @PathVariable Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }

    // Put con ResponseEntity Actualizar paciente

    @PutMapping
    public ResponseEntity<Paciente> actualizarPaciente( @RequestBody Paciente paciente){
        ResponseEntity<Paciente> response;
        if(paciente.getId() != null && pacienteService.buscar(paciente.getId())!= null){
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }


}
