package com.odontologos.odonto.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.odontologos.odonto.models.HorarioDisponible;

public interface HorarioDisponibleRepository extends JpaRepository<HorarioDisponible, Integer> {
    List<HorarioDisponible> findByOdontologoId(Integer idOdontologo);
}