package com.odontologos.odonto.DTO;

public class TratamientoPorSeguimientoDTO {
    private int id;
    private String descripcion;
    private String tratamientoDescripcion;
    private double precio;

    public TratamientoPorSeguimientoDTO(int id, String descripcion, String tratamientoDescripcion, double precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.tratamientoDescripcion = tratamientoDescripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTratamientoDescripcion() {
        return tratamientoDescripcion;
    }

    public void setTratamientoDescripcion(String tratamientoDescripcion) {
        this.tratamientoDescripcion = tratamientoDescripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}