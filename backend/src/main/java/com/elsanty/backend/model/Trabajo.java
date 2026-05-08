package com.elsanty.backend.model;

import java.math.BigDecimal;

import com.elsanty.backend.enums.CategoriaTrabajo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trabajos")
public class Trabajo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;
	
	@Enumerated(EnumType.STRING)
	private CategoriaTrabajo categoria;
	private BigDecimal precio;
	private boolean activo;
	
	//GETTERS
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public CategoriaTrabajo getCategoria() {
		return categoria;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public boolean isActivo() {
		return activo;
	}
	
	//SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCategoria(CategoriaTrabajo categoria) {
		this.categoria = categoria;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
