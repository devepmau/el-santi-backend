package com.elsanty.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

    @NotBlank(message = "La localidad es obligatoria")
    @Size(max = 100, message = "La localidad no puede superar 100 caracteres")
    public String localidad;

    public boolean barrioPrivado;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 150, message = "La dirección no puede superar 150 caracteres")
    public String direccion;

    @Min(value = 1, message = "El numero de altura/lote debe ser mayor a 0")
    @Max(value = 99999, message = "El numero de altura/lote es demasiado grande")
    public int alturaLote;

}
