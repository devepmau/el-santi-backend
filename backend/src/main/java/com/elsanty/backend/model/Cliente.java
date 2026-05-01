package com.elsanty.backend.model;

import java.time.LocalDate;

import com.elsanty.backend.enums.Cortes;
import com.elsanty.backend.enums.Horarios;
import com.elsanty.backend.enums.Prioridades;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDate fechaAlta;

	private String nombre;
	private String telefono;
	private String correoElectronico;

	private String provincia;
	private String localidad;

	private boolean barrioPrivado;
	private String direccion;
	private String barrio;
	private String lote;

	@Enumerated(EnumType.STRING)
	private Cortes preferenciaCorte;
	@Enumerated(EnumType.STRING)
	private Horarios preferenciaHoraria;
	private String preferenciaSemanal; //dias de la semana.
	
	private Double metrosCuadrados;
	private boolean tienePileta;
	private Double metrosPileta;
	private boolean tieneRiego;
	
	@Enumerated(EnumType.STRING)
	private Prioridades prioridad;
	private String observaciones;

	private boolean activo;

	//GETTERS
	public long getId() {
		return id;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
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

	public String getProvincia() {
		return provincia;
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

	public String getBarrio() {
		return barrio;
	}

	public String getLote() {
		return lote;
	}

	public Cortes getPreferenciaCorte() {
		return preferenciaCorte;
	}

	public Horarios getPreferenciaHoraria() {
		return preferenciaHoraria;
	}

	public String getPreferenciaSemanal() {
		return preferenciaSemanal;
	}

	public Double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public boolean isTienePileta() {
		return tienePileta;
	}

	public Double getMetrosPileta() {
		return metrosPileta;
	}

	public boolean isTieneRiego() {
		return tieneRiego;
	}

	public Prioridades getPrioridad() {
		return prioridad;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public boolean isActivo() {
		return activo;
	}

	//SETTERS
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
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

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public void setPreferenciaCorte(Cortes preferenciaCorte) {
		this.preferenciaCorte = preferenciaCorte;
	}

	public void setPreferenciaHoraria(Horarios preferenciaHoraria) {
		this.preferenciaHoraria = preferenciaHoraria;
	}

	public void setPreferenciaSemanal(String preferenciaSemanal) {
		this.preferenciaSemanal = preferenciaSemanal;
	}

	public void setMetrosCuadrados(Double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public void setTienePileta(boolean tienePileta) {
		this.tienePileta = tienePileta;
	}

	public void setMetrosPileta(Double metrosPileta) {
		this.metrosPileta = metrosPileta;
	}

	public void setTieneRiego(boolean tieneRiego) {
		this.tieneRiego = tieneRiego;
	}

	public void setPrioridad(Prioridades prioridad) {
		this.prioridad = prioridad;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
