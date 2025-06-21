package com.odontologos.odonto.repositories;
import com.odontologos.odonto.models.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguimientoRepository extends JpaRepository<Seguimiento, Integer> {
}
