package com.odontologos.odonto.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odontologos.odonto.DTO.CitaDetalleDTO;
import com.odontologos.odonto.models.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
    List<Cita> findByPaciente_IdPaciente(Integer idPaciente);

    @Query("SELECT new com.odontologos.odonto.DTO.CitaDetalleDTO(" +
           "c.idCita, CONCAT(o.nombres, ' ', o.apellidos), " +
           "s.descripcion, t.descripcion, c.fechaCita, c.hora, c.estado) " +
           "FROM Cita c " +
           "JOIN c.odontologo o " +
           "LEFT JOIN c.seguimiento s " +
           "LEFT JOIN c.tratamiento t " +
           "WHERE c.paciente.idPaciente = :idPaciente")
    List<CitaDetalleDTO> obtenerCitasDetalladasPorPaciente(@Param("idPaciente") Integer idPaciente);


    @Query("SELECT new com.odontologos.odonto.DTO.CitaDetalleDTO(" +
       "c.id, " +
       "CONCAT(o.nombres, ' ', o.apellidos), " +
       "s.descripcion, " +
       "t.descripcion, " +
       "c.fechaCita, " +
       "c.hora, " +
       "c.estado, " +
       "CONCAT(p.nombres, ' ', p.apellidos)) " +
       "FROM Cita c " +
       "JOIN c.odontologo o " +
       "JOIN c.paciente p " +
       "JOIN c.tratamiento t " +
       "JOIN c.seguimiento s " +
       "WHERE o.id = :idOdontologo")
    List<CitaDetalleDTO> obtenerCitasPorOdontologo(@Param("idOdontologo") Integer idOdontologo);

}
