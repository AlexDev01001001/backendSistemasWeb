package com.odontologos.odonto.controllers;

import com.odontologos.odonto.DTO.HorarioConOdontologoDTO;
import com.odontologos.odonto.models.HorarioDisponible;
import com.odontologos.odonto.repositories.HorarioDisponibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/horarios")
@CrossOrigin(origins = "*")

public class HorarioConOdontologoController {

    @Autowired
    private HorarioDisponibleRepository horarioRepository;
    
    /* TRAE DETALLE LA LISTA DE HORARIOS DISPONIBLES Y LOS DOCTORES ASOCIADAS A LA TABLA */
    @GetMapping("/detalle")
    public List<HorarioConOdontologoDTO> getTodosLosHorarios() {
        List<HorarioDisponible> horarios = horarioRepository.findAll();

        return horarios.stream().map(h -> new HorarioConOdontologoDTO(
                h.getId(),
                h.getFechaDisp().toString(),
                h.getHoraDisp().toString(),
                h.getOdontologo().getId(),
                h.getOdontologo().getNombres(),
                h.getOdontologo().getApellidos()
        )).collect(Collectors.toList());
}
}
