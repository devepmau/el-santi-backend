package com.elsanty.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "planes_mensuales")
public class PlanMensual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private LocalDate fechaInicio;

    private Integer frecuenciaMensual;

    private BigDecimal precioMensual;

    private boolean activo;
    
    //GETTERS
	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public Integer getFrecuenciaMensual() {
		return frecuenciaMensual;
	}

	public BigDecimal getPrecioMensual() {
		return precioMensual;
	}

	public boolean isActivo() {
		return activo;
	}

	//SETTERS
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFrecuenciaMensual(Integer frecuenciaMensual) {
		this.frecuenciaMensual = frecuenciaMensual;
	}

	public void setPrecioMensual(BigDecimal precioMensual) {
		this.precioMensual = precioMensual;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
