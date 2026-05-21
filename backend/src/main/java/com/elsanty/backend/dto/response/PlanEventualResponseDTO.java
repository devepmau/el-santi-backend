package com.elsanty.backend.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.elsanty.backend.enums.Estado;

public class PlanEventualResponseDTO {
	
	public Long id;
	public Long clienteId;
	public String clienteNombre;
	public boolean clienteActivo;
	public LocalDate fechaInicio;
	public LocalDate fechaDeFin;
	public BigDecimal precio;
	public Estado estado;

}
