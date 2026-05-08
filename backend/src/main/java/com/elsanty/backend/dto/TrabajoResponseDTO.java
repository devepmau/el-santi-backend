package com.elsanty.backend.dto;

import java.math.BigDecimal;

import com.elsanty.backend.enums.CategoriaTrabajo;

public class TrabajoResponseDTO {
	
	public Long id;
	public String nombre;
	public String descripcion;
	public CategoriaTrabajo categoria;
	public BigDecimal precio;
	public boolean activo;

}
