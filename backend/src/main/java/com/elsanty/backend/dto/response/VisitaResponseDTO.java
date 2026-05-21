package com.elsanty.backend.dto.response;

import java.time.LocalDateTime;

import com.elsanty.backend.enums.EstadoVisita;

public class VisitaResponseDTO {

    public Long id;
    public Long planMensualId;
    public LocalDateTime fecha;
    public EstadoVisita estado;
    public String observaciones;
}