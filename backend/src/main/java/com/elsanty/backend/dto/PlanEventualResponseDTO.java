package com.elsanty.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.elsanty.backend.enums.EstadoVisita;

public class PlanEventualResponseDTO {
	
	public Long id;
	public Long clienteId;
	public String clienteNombre;
	public boolean clienteActivo;
	public LocalDate fechaInicio;
	public LocalDate fechaDeFin;
	public BigDecimal precio;
	public EstadoVisita estado;

}
