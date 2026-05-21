package com.elsanty.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsanty.backend.dto.request.PlanMensualRequestDTO;
import com.elsanty.backend.dto.response.PlanMensualResponseDTO;
import com.elsanty.backend.dto.update.PlanMensualUpdateDTO;
import com.elsanty.backend.service.PlanMensualService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/planes-mensuales")
@CrossOrigin(origins = "http://localhost:3000")
public class PlanMensualController {
	
	private final PlanMensualService service;
	
	public PlanMensualController(PlanMensualService service) {
		this.service = service;
	}
	
	@Operation(summary = "Obtener plan mensual por ID")
	@GetMapping("/{id}")
	public PlanMensualResponseDTO obtenerporId(@PathVariable Long id) {
		return service.obtenerporId(id);
	}
	
	@Operation(summary = "Listar todos los planes mensuales")
	@GetMapping
	public List<PlanMensualResponseDTO> listar(){
		return service.listar();
	}
	
	@Operation(summary = "Crear un nuevo plan mensual")
	@PostMapping
	public PlanMensualResponseDTO crear(@Valid @RequestBody PlanMensualRequestDTO dto) {
		return service.crear(dto);
	}
	
	@Operation(summary = "Actualizar un plan mensual existente")
	@PutMapping("/{id}")
	public PlanMensualResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody PlanMensualUpdateDTO dto) {
		return service.actualizar(id, dto);
	}
	
	@Operation(summary = "Desactivar un plan mensual")
	@PutMapping("/{id}/desactivar")
	public PlanMensualResponseDTO desactivar(@PathVariable Long id) {
		return service.desactivar(id);
	}
	
	@Operation(summary = "Eliminar un plan mensual")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		service.eliminar(id);
	}

}
