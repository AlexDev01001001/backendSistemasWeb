package com.odontologos.odonto.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odontologos.odonto.models.PacienteUsuario;
import com.odontologos.odonto.repositories.PacienteUsuarioRepository;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteUsuarioController {
    @Autowired
    private PacienteUsuarioRepository pacienteRepository;

    /* API QUE GUARDA REGISTRO Y VALIDA DNI */
    @PostMapping("/registro")
    public Map<String, String> registrarPaciente(@RequestBody PacienteUsuario paciente) {
    Map<String, String> response = new HashMap<>();

    if (pacienteRepository.existsByDni(paciente.getDni())) {
        response.put("mensaje", "El DNI ya está registrado.");
        return response;
    }

    paciente.setFechaRegistro(LocalDate.now());
    pacienteRepository.save(paciente);
    response.put("mensaje", "Paciente registrado correctamente.");
    return response;
    }

    @GetMapping
    public List<PacienteUsuario> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }

    /* API PARA LOGIN, COMPARA CONTRASEÑA Y CORREO */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
    String correo = loginData.get("correo");
    String contraseña = loginData.get("contraseña");

    Optional<PacienteUsuario> paciente = pacienteRepository.findByCorreoAndContraseña(correo, contraseña);

    if (paciente.isPresent()) {
            return ResponseEntity.ok(paciente.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos.");
        }
    }
}
