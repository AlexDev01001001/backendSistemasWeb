package com.odontologos.odonto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odontologos.odonto.models.Cita;
import com.odontologos.odonto.repositories.CitaRepository;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> getCitasPorPaciente(Integer idPaciente) {
        return citaRepository.findByPaciente_IdPaciente(idPaciente);
    }
}
