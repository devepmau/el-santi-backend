package com.elsanty.backend.dto;

import com.elsanty.backend.enums.Cortes;
import com.elsanty.backend.enums.Horarios;
import com.elsanty.backend.enums.Prioridades;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ClienteUpdateDTO {
	
	@Schema(description = "Nombre del cliente", example = "Marcos Mansilla")
	@NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    public String nombre;

	@Schema(description = "Numero de telefono", example = "1122334455")
    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d{10,15}", message = "El teléfono debe contener entre 10 y 15 números")
    public String telefono;

	@Schema(description = "EMail del cliente", example = "marcos@mail.com")
    @Email(message = "El correo electrónico no es válido")
    public String correoElectronico;

    @NotBlank(message = "La provincia es obligatoria")
    public String provincia;
    
    @NotBlank(message = "La localidad es obligatoria")
    @Size(max = 100, message = "La localidad no puede superar 100 caracteres")
    public String localidad;

    public boolean barrioPrivado;

    @Schema(description = "Direccion del cliente", example = "Calle Falsa 123")
    @Size(max = 150, message = "La dirección no puede superar 150 caracteres")
    public String direccion;
    
    @Size(max = 150, message = "El nombre del barrio no puede superar 150 caracteres")
    public String barrio;

    @Schema(description = "N° lote del cliente dentro del barrio privado", example = "A123")
    @Size(max = 10, message = "El numero de lote no puede superar 10 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9-]+$", message = "El lote solo puede contener letras y numeros")
    public String lote;
    
    @Schema(description = "Altura de corte preferida", example = "BAJO")
	public Cortes preferenciaCorte;
	
    @Schema(description = "Horario de visita preferido", example = "MAÑANA")
	public Horarios preferenciaHoraria;
	
    @Schema(description = "Dias que prefiere el cliente para la visita", example = "Lunes, Miércoles y Viernes")
	public String preferenciaSemanal;
	
	@Positive(message = "Los metros cuadrados deben ser mayores a 0")
	public Double metrosCuadrados;
	
	public boolean tienePileta;
	
	@Positive(message = "Los metros de la pileta deben ser mayores a 0")
	public Double metrosPileta;
	
	public boolean tieneRiego;
	
	@Schema(description = "Prioridad de atencion por sobre otros clientes", example = "ALTA")
	public Prioridades prioridad;
	
	@Schema(description = "Datos extras sobre el cliente", example = "El cliente tiene perros agresivos, avisar antes de ingresar")
	public String observaciones;
	
	public boolean activo;

}
