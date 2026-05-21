package com.elsanty.backend.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PlanEventualRequestDTO {
	
	@Schema(description = "ID del cliente", example = "1")
	@NotNull(message = "El cliente es obligatorio")
	public Long clienteId;
	
	@Schema(description = "Fecha de inicio del contrato", example = "2026-05-05")
	@NotNull(message = "La fecha de inicio es obligatoria")
	@FutureOrPresent(message = "La fecha debe ser del presente o el futuro")
	public LocalDate fechaDeInicio;
	
	@Schema(description = "Fechade fin de contrato (tentativa mientras sea 'PENDIENTE')", example = "2026-05-07")
	@FutureOrPresent(message = "La fecha debe ser del presente o el futuro")
	public LocalDate fechaDeFin;
	
	@NotNull(message = "El precio es obligatorio")
	@Positive(message = "El precio debe ser mayor a 0")
	public BigDecimal precio;

}
