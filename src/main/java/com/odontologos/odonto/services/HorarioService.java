package com.odontologos.odonto.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.odontologos.odonto.models.HorarioDisponible;
import com.odontologos.odonto.repositories.HorarioDisponibleRepository;

@Service
public class HorarioService {

    private final HorarioDisponibleRepository horarioRepo;

    public HorarioService(HorarioDisponibleRepository horarioRepo) {
        this.horarioRepo = horarioRepo;
    }

    public List<HorarioDisponible> obtenerPorOdontologo(Integer idOdontologo) {
        return horarioRepo.findByOdontologoId(idOdontologo);
    }
}