package com.odontologos.odonto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odontologos.odonto.models.Tratamiento;
import com.odontologos.odonto.repositories.TratamientoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/tratamientos")
@CrossOrigin("*")

public class TratamientoController {
    @Autowired
    private TratamientoRepository tratamientoRepo;

    @GetMapping("/seguimiento/{id}")
    public List<Tratamiento> getTratamientoPorSeguimiento(@PathVariable Integer id){
        return tratamientoRepo.findBySeguimientoId(id);
    }
    
}
