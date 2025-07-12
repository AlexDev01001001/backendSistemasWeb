package com.odontologos.odonto.controllers;

import com.odontologos.odonto.models.Odontologo;
import com.odontologos.odonto.repositories.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.odontologos.odonto.DTO.OdontologoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/odontologos")
@CrossOrigin(origins = "*")
public class OdontologoController {

    @Autowired
    private OdontologoRepository odontologoRepository;

        @GetMapping
        public List<OdontologoDTO> obtenerTodosLosOdontologos() {
            List<Odontologo> odontologos = odontologoRepository.findAll();
            return odontologos.stream()
                .map(o -> new OdontologoDTO(
                    o.getId(),
                    o.getNombres(),
                    o.getApellidos(),
                    o.getCorreo(),
                    o.getContraseña()
                ))
                .toList();
        }
}
