package com.elsanty.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteUpdateDTO {
	
	@NotBlank(message = "El nombre es obligatorio")
	public String nombre;
	
	@NotBlank(message = "El teléfono es obligatorio")
	@Pattern(regexp = "\\d+", message = "El teléfono debe contener solo números")
	@Size(min = 10, message = "El teléfono debe tener al menos 10 dígitos")
	public String telefono;
	
	public String correoElectronico;
	public String localidad;
	public boolean barrioPrivado;
	public String direccion;
	public int alturaLote;
	public boolean activo;

}
