package com.odontologos.odonto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.odontologos.odonto.models.Odontologo;

public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
}