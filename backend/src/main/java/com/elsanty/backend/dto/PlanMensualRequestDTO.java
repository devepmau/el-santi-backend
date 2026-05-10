package com.elsanty.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PlanMensualRequestDTO {

	@Schema(description = "ID del cliente", example = "1")
	@NotNull(message = "El cliente es obligatorio")
    public Long clienteId;

	@Schema(description = "Fecha de inicio del contrato", example = "2026-05-05")
	@NotNull(message = "La fecha de inicio es obligatoria")
    public LocalDate fechaInicio;
	
	@Schema(description = "N° de visitar a realizar al mes", example = "4")
	@NotNull(message = "La frecuencia es obligatoria")
    @Min(value = 1, message = "Debe haber al menos 1 visita")
    @Max(value = 31, message = "Frecuencia inválida")
    public Integer frecuenciaMensual;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    public BigDecimal precioMensual;
}