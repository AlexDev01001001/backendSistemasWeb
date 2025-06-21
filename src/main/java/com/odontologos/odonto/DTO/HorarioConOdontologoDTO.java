package com.odontologos.odonto.DTO;

public class HorarioConOdontologoDTO {
    private Integer id;
    private String fechaDisp;
    private String horaDisp;
    private OdontologoDTO odontologo;

    public HorarioConOdontologoDTO(Integer id, String fechaDisp, String horaDisp,Integer idOdontologo ,String nombres, String apellidos) {
        this.id = id;
        this.fechaDisp = fechaDisp;
        this.horaDisp = horaDisp;
        this.odontologo = new OdontologoDTO(idOdontologo, nombres, apellidos);
    }

    // Getters
    public Integer getId() { return id; }
    public String getFechaDisp() { return fechaDisp; }
    public String getHoraDisp() { return horaDisp; }
    public OdontologoDTO getOdontologo() { return odontologo; }

    // Sub-clase DTO del odontólogo
    public static class OdontologoDTO {
        private String nombres;
        private String apellidos;
        private Integer idOdontologo;

        public OdontologoDTO(Integer idOdontologo, String nombres, String apellidos) {
            this.idOdontologo= idOdontologo;
            this.nombres = nombres;
            this.apellidos = apellidos;
        }

        public Integer getIdOdontologo() {return idOdontologo;}
        public String getNombres() { return nombres; }
        public String getApellidos() { return apellidos; }
    }
}