package com.odontologos.odonto.controllers;

import com.odontologos.odonto.DTO.CitaDetalleDTO;
import com.odontologos.odonto.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/odontologos")
@CrossOrigin(origins = "*")
public class OdontologoCitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/{idOdontologo}/citas")
    public List<CitaDetalleDTO> getCitasPorOdontologo(@PathVariable Integer idOdontologo) {
        return citaService.obtenerCitasPorOdontologo(idOdontologo);
    }
}