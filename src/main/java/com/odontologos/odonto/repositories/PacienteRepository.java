package com.odontologos.odonto.repositories;
import com.odontologos.odonto.models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

}
