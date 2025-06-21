package com.odontologos.odonto.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odontologos.odonto.DTO.CitaDetalleDTO;
import com.odontologos.odonto.models.Cita;
import com.odontologos.odonto.repositories.AdminRepository;
import com.odontologos.odonto.repositories.CitaRepository;
import com.odontologos.odonto.repositories.ConsultorioRepository;
import com.odontologos.odonto.repositories.OdontologoRepository;
import com.odontologos.odonto.repositories.PacienteUsuarioRepository;
import com.odontologos.odonto.repositories.SeguimientoRepository;
import com.odontologos.odonto.repositories.TratamientoRepository;
import com.odontologos.odonto.services.CitaService;
import com.odontologos.odonto.DTO.CitaDTO;

@RestController
@RequestMapping("api/pacientes")
@CrossOrigin(origins = "*")

public class CitaController {

    /*private final CitaRepository citaRepository;
    @Autowired
    private CitaService citaService;*/

    @Autowired private CitaRepository citaRepository;
    @Autowired private CitaService citaService;

    // Repos para relaciones
    @Autowired private ConsultorioRepository consultorioRepo;
    @Autowired private AdminRepository adminRepo;
    @Autowired private PacienteUsuarioRepository pacienteRepo;
    @Autowired private OdontologoRepository odontologoRepo;
    @Autowired private SeguimientoRepository seguimientoRepo;
    @Autowired private TratamientoRepository tratamientoRepo;

    CitaController(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @GetMapping("/{id}/citas")
    public ResponseEntity<List<Cita>> obtenerCitasPorPaciente(@PathVariable Integer id) {
        List<Cita> citas = citaService.getCitasPorPaciente(id);
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/citas/{idPaciente}")
    public List<CitaDetalleDTO> obtenerCitasPaciente(@PathVariable Integer idPaciente) {
        return citaRepository.obtenerCitasDetalladasPorPaciente(idPaciente);
    }

    /* CANCELAR CITA */ 
    @PutMapping("/citas/{id}/cancelar")
    public ResponseEntity<?> cancelarCita(@PathVariable Integer id) {
        Optional<Cita> optCita = citaRepository.findById(id);
        if (optCita.isPresent()) {
            Cita cita = optCita.get();
            cita.setEstado(3); // Cancelada
            citaRepository.save(cita);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



        /* REGISTRO DE CITAS */
        @PostMapping("/citas")
        public ResponseEntity<Map<String, String>> registrarCita(@RequestBody CitaDTO dto) {
            Map<String, String> response = new HashMap<>();

            try {
                Cita cita = new Cita();
                cita.setFechaCita(java.sql.Date.valueOf(dto.getFechaCita()));
                cita.setHora(java.sql.Time.valueOf(dto.getHora()));
                cita.setEstado(dto.getEstado());
                cita.setPrecioConsulta(dto.getPrecioConsulta());

                // Asignar relaciones
                cita.setConsultorio(consultorioRepo.findById(dto.getIdConsultorio()).orElse(null));
                cita.setAdmin(adminRepo.findById(dto.getIdAdmin()).orElse(null));
                cita.setPaciente(pacienteRepo.findById(dto.getIdPaciente()).orElse(null));
                cita.setOdontologo(odontologoRepo.findById(dto.getIdOdontologo()).orElse(null));
                cita.setSeguimiento(seguimientoRepo.findById(dto.getIdSeguimiento()).orElse(null));
                cita.setTratamiento(tratamientoRepo.findById(dto.getIdTratamiento()).orElse(null));

                citaRepository.save(cita);

                response.put("mensaje", "Cita registrada exitosamente.");
                return ResponseEntity.status(HttpStatus.CREATED).body(response);

            } catch (Exception e) {
                response.put("error", "Error al registrar cita: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        }

}
