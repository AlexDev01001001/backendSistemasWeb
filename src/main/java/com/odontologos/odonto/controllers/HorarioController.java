package com.odontologos.odonto.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.odontologos.odonto.models.HorarioDisponible;
import com.odontologos.odonto.services.HorarioService;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping("/odontologo/{id}")
    public List<HorarioDisponible> getHorariosPorOdontologo(@PathVariable Integer id) {
        return horarioService.obtenerPorOdontologo(id);
    }
}