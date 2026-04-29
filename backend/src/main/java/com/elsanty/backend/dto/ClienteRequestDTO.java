package com.elsanty.backend.dto;

import com.elsanty.backend.enums.Cortes;
import com.elsanty.backend.enums.Horarios;
import com.elsanty.backend.enums.Prioridades;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteRequestDTO {
	
	@NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    public String nombre;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d{10,15}", message = "El teléfono debe contener entre 10 y 15 números")
    public String telefono;

    @Email(message = "El correo electrónico no es válido")
    public String correoElectronico;

    @NotBlank(message = "La provincia es obligatoria")
    public String provincia;
    
    @NotBlank(message = "La localidad es obligatoria")
    @Size(max = 100, message = "La localidad no puede superar 100 caracteres")
    public String localidad;

    public boolean barrioPrivado;

    @Size(max = 150, message = "La dirección no puede superar 150 caracteres")
    public String direccion;
    
    @Size(max = 150, message = "El nombre del barrio no puede superar 150 caracteres")
    public String barrio;

    @Size(max = 10, message = "El numero de lote no puede superar 10 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9-]+$", message = "El lote solo puede contener letras y numeros")
    public String lote;
    
	public Cortes preferenciaCorte;
	
	public Horarios preferenciaHoraria;
	
	public String preferenciaSemanal;
	
	public Prioridades prioridad;
	
	public String observaciones;

}
