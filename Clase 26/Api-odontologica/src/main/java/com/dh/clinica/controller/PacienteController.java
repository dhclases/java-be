package com.dh.clinica.controller;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.repository.impl.PacienteDaoH2;
import com.dh.clinica.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    // No se usa anotacion @Service
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    // Get usando ResponseEntity Obtener Todos los Pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    // Put con ResponseEntity Actualizar paciente
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable("id") Integer id,
                                               @RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response;

        if (paciente.getId() != null && pacienteService.buscar(paciente.getId()) != null)
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    // DUDA 1

    @GetMapping("/hijos/{name}/{lastname}/{age}/{gender}/")
    public ResponseEntity<String> mostrarHijos
            (@PathVariable("name") String nombre,
             @PathVariable("lastname") String apellido,
             @PathVariable("age") Integer edad,
             @PathVariable("gender") String gender) {
        return ResponseEntity.ok(String.format("Estos son las entrada: (1) = %s, (2) = %s (2) = %s (3) = %s", nombre, apellido, edad, gender));
    }

    // Duda 2
    @GetMapping("/auditoria")
    public ResponseEntity<String> mostrarAuditoria(@RequestParam("userId") String userId) {
        return ResponseEntity.ok(String.format("Estos son las entrada: (1) = %s", userId));
    }

    // Pos con ResponseEntity Crear Paciente y devolver status
    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        return new ResponseEntity<>(pacienteService.guardar(paciente), HttpStatus.CREATED);
    }


    // Get By ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id) {
        ResponseEntity<Paciente> response;
        if (id != 0) {
            response = ResponseEntity.ok(pacienteService.buscar(id));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
    // Delete by ID

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrarPorId(@PathVariable Integer id) {
        ResponseEntity<HttpStatus> response;
        if (id != 0 &&  Objects.nonNull(pacienteService.buscar(id))) {
            pacienteService.eliminar(id);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }


}
