package com.elsanty.backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elsanty.backend.dto.PlanEventualRequestDTO;
import com.elsanty.backend.dto.PlanEventualResponseDTO;
import com.elsanty.backend.dto.PlanEventualUpdateDTO;
import com.elsanty.backend.service.PlanEventualService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/planes-eventuales")
@CrossOrigin(origins = "http://localhost:3000")
public class PlanEventualController {
	
	private final PlanEventualService service;
	
	public PlanEventualController(PlanEventualService service) {
		this.service = service;
	}
	
	@Operation(summary = "Obtener plan eventual por ID")
	@GetMapping("/{id}")
	public PlanEventualResponseDTO obtenerPorId(@PathVariable Long id) {
		return service.obtenerPorId(id);
	}
	
	@Operation(summary = "Listar todos los planes eventuales")
	@GetMapping
	public List<PlanEventualResponseDTO> listar(){
		return service.listar();
	}
	
	@Operation(summary = "Crear un nuevo plan eventual")
	@PostMapping
	public PlanEventualResponseDTO crear(@Valid @RequestBody PlanEventualRequestDTO dto) {
		return service.crear(dto);
	}
	
	@Operation(summary = "Actualizar un plan eventual existente")
	@PutMapping("/{id}")
	public PlanEventualResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody PlanEventualUpdateDTO dto) {
		return service.actualizar(id, dto);
	}
	
	@Operation(summary = "Cancelar un plan eventual")
	@PutMapping("/{id}/cancelar")
	public PlanEventualResponseDTO cancelar(@PathVariable Long id) {
		return service.cancelar(id);
	}
	
	@Operation(summary = "Finalizar un plan eventual")
	@PutMapping("/{id}/finalizar")
	public PlanEventualResponseDTO finalizar(@PathVariable Long id) {
		return service.finalizar(id);
	}
	
	@Operation(summary = "Reactivar un plan eventual cancelado")
	@PutMapping("/{id}/reactivar")
	public PlanEventualResponseDTO reactivar(@PathVariable Long id, @RequestParam LocalDate fecha) {
		return service.reactivar(id, fecha);
	}
	
	@Operation(summary = "Modificar la fecha de inicio de un plan")
	@PutMapping("7{id}/reprogramar")
	public PlanEventualResponseDTO reprogramar(@PathVariable Long id, @RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
		return service.reprogramar(id, fechaInicio, fechaFin);
	}
	
	@Operation(summary = "Eliminar un plan eventual")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		service.eliminar(id);
	}

}
