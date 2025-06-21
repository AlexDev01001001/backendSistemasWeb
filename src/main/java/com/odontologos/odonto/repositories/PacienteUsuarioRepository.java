package com.odontologos.odonto.repositories;

import com.odontologos.odonto.models.PacienteUsuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteUsuarioRepository extends JpaRepository<PacienteUsuario, Integer> {
    boolean existsByDni(String dni);
    Optional<PacienteUsuario> findByCorreoAndContraseña(String correo, String contraseña);
}


