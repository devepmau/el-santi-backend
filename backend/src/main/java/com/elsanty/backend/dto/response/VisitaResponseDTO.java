package com.elsanty.backend.dto.response;

import java.time.LocalDateTime;

import com.elsanty.backend.enums.Estado;

public class VisitaResponseDTO {

    public Long id;
    public Long planMensualId;
    public LocalDateTime fecha;
    public Estado estado;
    public String observaciones;
}