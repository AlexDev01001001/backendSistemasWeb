package com.odontologos.odonto.models;

import jakarta.persistence.*;

@Entity
public class Tratamiento {
    @Id
    private Integer id_tratamiento;

    private String descripcion;
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_seguimiento")
    private Seguimiento seguimiento;

    public Integer getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(Integer id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

   
}