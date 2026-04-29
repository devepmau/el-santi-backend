package com.elsanty.backend.dto;

import java.time.LocalDate;

import com.elsanty.backend.enums.Cortes;
import com.elsanty.backend.enums.Horarios;
import com.elsanty.backend.enums.Prioridades;

public class ClienteResponseDTO {
	
	public long id;
	public LocalDate fechaAlta;
	public String nombre;
	public String telefono;
	public String correoElectronico;
	public String provincia;
	public String localidad;
	public boolean barrioPrivado;
	public String direccion;
	public String barrio;
	public String lote;
	public Cortes preferenciaCorte;
	public Horarios preferenciaHoraria;
	public String preferenciaSemanal;
	public Prioridades prioridad;
	public String observaciones;
	public boolean activo;

}
