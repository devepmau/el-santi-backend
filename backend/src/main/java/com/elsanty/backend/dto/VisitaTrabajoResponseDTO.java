package com.elsanty.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VisitaTrabajoResponseDTO {
	
	public Long id;
	public Long visitaId;
	public LocalDateTime VisitaFecha;
	public Long trabajoId;
	public String trabajoNombre;
	public BigDecimal trabajoPrecio;
	public Integer cantidad;
	public BigDecimal precioAplicado;

}
