package com.odontologos.odonto.DTO;

import java.sql.Date;
import java.sql.Time;

public class CitaDetalleDTO {
    private Integer idCita;
    private String odontologoNombre;
    private String seguimientoDescripcion;
    private String tratamientoDescripcion;
    private Date fechaCita;
    private Time hora;
    private Integer estado;
    private String pacienteNombre;
    

    public CitaDetalleDTO(Integer idCita, String odontologoNombre, String seguimientoDescripcion,
                          String tratamientoDescripcion, Date fechaCita, Time hora, Integer estado) {
        this.idCita = idCita;
        this.odontologoNombre = odontologoNombre;
        this.seguimientoDescripcion = seguimientoDescripcion;
        this.tratamientoDescripcion = tratamientoDescripcion;
        this.fechaCita = fechaCita;
        this.hora = hora;
        this.estado = estado;
        
    }

    public CitaDetalleDTO(Integer idCita, String odontologoNombre, String seguimientoDescripcion,
                        String tratamientoDescripcion, Date fechaCita, Time hora,
                        Integer estado, String pacienteNombre) {
        this.idCita = idCita;
        this.odontologoNombre = odontologoNombre;
        this.seguimientoDescripcion = seguimientoDescripcion;
        this.tratamientoDescripcion = tratamientoDescripcion;
        this.fechaCita = fechaCita;
        this.hora = hora;
        this.estado = estado;
        this.pacienteNombre = pacienteNombre;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public String getOdontologoNombre() {
        return odontologoNombre;
    }

    public void setOdontologoNombre(String odontologoNombre) {
        this.odontologoNombre = odontologoNombre;
    }

    public String getSeguimientoDescripcion() {
        return seguimientoDescripcion;
    }

    public void setSeguimientoDescripcion(String seguimientoDescripcion) {
        this.seguimientoDescripcion = seguimientoDescripcion;
    }

    public String getTratamientoDescripcion() {
        return tratamientoDescripcion;
    }

    public void setTratamientoDescripcion(String tratamientoDescripcion) {
        this.tratamientoDescripcion = tratamientoDescripcion;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }


    
}