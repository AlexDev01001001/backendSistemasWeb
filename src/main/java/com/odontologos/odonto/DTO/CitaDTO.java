package com.odontologos.odonto.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDTO {

    private LocalDate fechaCita;
    private LocalTime hora;
    private int estado;

    private Integer idConsultorio;
    private Integer idAdmin;
    private Integer idPaciente;
    private Integer idOdontologo;
    private Integer idSeguimiento;
    private Integer idTratamiento;
    private BigDecimal precioConsulta;
    public LocalDate getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public Integer getIdConsultorio() {
        return idConsultorio;
    }
    public void setIdConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }
    public Integer getIdAdmin() {
        return idAdmin;
    }
    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }
    public Integer getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    public Integer getIdOdontologo() {
        return idOdontologo;
    }
    public void setIdOdontologo(Integer idOdontologo) {
        this.idOdontologo = idOdontologo;
    }
    public Integer getIdSeguimiento() {
        return idSeguimiento;
    }
    public void setIdSeguimiento(Integer idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }
    public Integer getIdTratamiento() {
        return idTratamiento;
    }
    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }
    public BigDecimal getPrecioConsulta() {
        return precioConsulta;
    }
    public void setPrecioConsulta(BigDecimal precioConsulta) {
        this.precioConsulta = precioConsulta;
    }
    
    
   
}
