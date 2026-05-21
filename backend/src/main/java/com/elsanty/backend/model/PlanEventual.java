package com.elsanty.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.elsanty.backend.enums.Estado;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "planes_eventuales")
public class PlanEventual {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	private LocalDate fechaDeInicio;
	
	private LocalDate fechaDeFin;
	
	private BigDecimal precio;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;

	//GETTERS
	
	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}
	
	public LocalDate getFechaDefin() {
		return fechaDeFin;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public Estado getEstado() {
		return estado;
	}

	//SETTERS
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}
	
	public void setFechaDeFin(LocalDate fechaDeFin) {
		this.fechaDeFin = fechaDeFin;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
