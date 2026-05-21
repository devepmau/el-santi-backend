package com.elsanty.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.elsanty.backend.enums.Estado;

@Entity
@Table(name = "visitas")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private PlanMensual planMensual;

    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private String observaciones;

    
    //GETTERS
	public Long getId() {
		return id;
	}

	public PlanMensual getPlanMensual() {
		return planMensual;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	//SETTERS
	public void setPlanMensual(PlanMensual planMensual) {
		this.planMensual = planMensual;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}