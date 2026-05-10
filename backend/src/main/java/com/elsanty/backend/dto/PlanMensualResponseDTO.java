package com.elsanty.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlanMensualResponseDTO {
	
	public Long id;
    public Long clienteId;
    public String clienteNombre;
    public boolean clienteActivo;
    public LocalDate fechaInicio;
    public Integer frecuenciaMensual;
    public BigDecimal precioMensual;
    public boolean activo;

}
