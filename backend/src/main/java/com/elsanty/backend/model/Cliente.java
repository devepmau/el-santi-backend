package com.elsanty.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String telefono;
	private String correoElectronico;
	private String localidad;
	private boolean barrioPrivado;
	private String direccion;
	private int alturaLote;
	private boolean activo;
	
	//GETTERS
	public long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public String getLocalidad() {
		return localidad;
	}
	public boolean isBarrioPrivado() {
		return barrioPrivado;
	}
	public String getDireccion() {
		return direccion;
	}
	public int getAlturaLote() {
		return alturaLote;
	}
	public boolean isActivo() {
		return activo;
	}

	//SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public void setBarrioPrivado(boolean barrioPrivado) {
		this.barrioPrivado = barrioPrivado;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setAlturaLote(int alturaLote) {
		this.alturaLote = alturaLote;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
