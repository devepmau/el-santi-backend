package com.elsanty.backend.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "visita_trabajo")
public class VisitaTrabajo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visita_id", nullable = false)
	private Visita visita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trabajo_id", nullable = false)
	private Trabajo trabajo;
	
	private Integer cantidad;
	
	private BigDecimal precioAplicado;

	//GETTERS
	
	public Long getId() {
		return id;
	}

	public Visita getVisita() {
		return visita;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public BigDecimal getPrecioAplicado() {
		return precioAplicado;
	}

	//SETTERS

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecioAplicado(BigDecimal precioAplicado) {
		this.precioAplicado = precioAplicado;
	}

}
