package com.elsanty.backend.dto.request;

import java.math.BigDecimal;

import com.elsanty.backend.enums.CategoriaTrabajo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TrabajoRequestDTO {
	
	@Schema(description = "Nombre del trabajo", example = "Cortar cesped")
	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
	public String nombre;
	
	@Schema(description = "Que se hace en este trabajo", example = "Corte de cesped con maquina a explision")
	public String descripcion;
	
	@Schema(description = "Categoria del trabajo", example = "JARDIN")
	public CategoriaTrabajo categoria;
	
	@Schema(description = "Precio del trabajo por visita", example = "150000")
	@NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
	public BigDecimal precio;
	

}
