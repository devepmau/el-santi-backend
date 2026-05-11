package com.elsanty.backend.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class VisitaRequestDTO {

	@Schema(description = "ID del plan mensual al que pertenece la visita", example = "1")
	@NotNull(message = "El plan mensual es obligatorio")
	public Long planMensualId;
	
	@Schema(description = "Fecha y hora de la visita", example = "2026-05-05T10:00:00")
	public LocalDateTime fecha;

	@Schema(description = "Observaciones de la visita", example = "Se daño un riego con la maquina, se reparo y se dejo funcionando")
	public String observaciones;
}