package com.odontologos.odonto.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Seguimiento {
    @Id
    @Column(name = "id_seguimiento")
    private Integer id;

    private String descripcion;

    @OneToMany(mappedBy = "seguimiento")
    private List<Tratamiento> tratamientos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }



}