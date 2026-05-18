package com.elsanty.backend.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VisitaTrabajoUpdateDTO {
	
	@Schema(description = "ID de la visita", example = "1")
	public Long visitaId;
	
	@Schema(description = "ID del trabajo", example = "1")
	public Long trabajoId;
	
	@Schema(description = "Cantidad de repeticiones del trabajo", example = "2")
	@NotNull(message = "La cantidad es obligatoria")
	@Min(value = 1, message = "Debe tener al menos una repetición")
	public Integer cantidad;
	
	@NotNull(message = "El precio aplicado es obligatorio")
	@Positive(message = "El precio aplicado debe ser mayor a 0")
	public BigDecimal precioAplicado;

}
