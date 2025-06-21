package com.odontologos.odonto.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odontologos.odonto.DTO.TratamientoPorSeguimientoDTO;
import com.odontologos.odonto.models.Seguimiento;
import com.odontologos.odonto.models.Tratamiento;
import com.odontologos.odonto.repositories.SeguimientoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/seguimientos")
@CrossOrigin(origins = "*")
public class SeguimientoController {

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    
    @GetMapping("/detalle")
    public List<TratamientoPorSeguimientoDTO> getSeguimientosConTratamientos() {
        List<Seguimiento> seguimientos = seguimientoRepository.findAll();

        List<TratamientoPorSeguimientoDTO> resultado = new ArrayList<>();

        for (Seguimiento s : seguimientos) {
            for (Tratamiento t : s.getTratamientos()) {
                resultado.add(new TratamientoPorSeguimientoDTO(
                        s.getId(),
                        s.getDescripcion(),
                        t.getDescripcion(),
                        t.getPrecio()
                ));
            }
        }

        return resultado;
    }
}
