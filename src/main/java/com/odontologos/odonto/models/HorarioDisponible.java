package com.odontologos.odonto.models;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "horarios_disponibles")
public class HorarioDisponible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Integer id;

    private Date fechaDisp;
    private Time horaDisp;

    @ManyToOne
    @JoinColumn(name = "id_odontologo")
    private Odontologo odontologo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaDisp() {
        return fechaDisp;
    }

    public void setFechaDisp(Date fechaDisp) {
        this.fechaDisp = fechaDisp;
    }

    public Time getHoraDisp() {
        return horaDisp;
    }

    public void setHoraDisp(Time horaDisp) {
        this.horaDisp = horaDisp;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    
}