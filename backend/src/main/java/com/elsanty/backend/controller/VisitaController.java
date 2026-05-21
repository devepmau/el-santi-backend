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

import com.elsanty.backend.dto.request.VisitaRequestDTO;
import com.elsanty.backend.dto.response.VisitaResponseDTO;
import com.elsanty.backend.dto.update.VisitaUpdateDTO;
import com.elsanty.backend.service.VisitaService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/visitas")
@CrossOrigin(origins = "http://localhost:3000")
public class VisitaController {
	
	private final VisitaService service;
	
	public VisitaController(VisitaService service) {
		this.service = service;
	}
	
	@Operation(summary = "Obtener visita por ID")
	@GetMapping("/{id}")
	public VisitaResponseDTO obtenerPorId(@PathVariable Long id) {
		return service.obtenerPorId(id);
	}
	
	@Operation(summary = "Listar todas las visitas")
	@GetMapping
	public List<VisitaResponseDTO> listar(){
		return service.listar();
	}
	
	@Operation(summary = "Crear una nueva visita")
	@PostMapping
	public VisitaResponseDTO crear(@Valid @RequestBody VisitaRequestDTO dto) {
		return service.crear(dto);
	}
	
	@Operation(summary = "Actualizar una visita existente")
	@PutMapping("/{id}")
	public VisitaResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody VisitaUpdateDTO dto) {
		return service.actualizar(id, dto);
	}
	
	@Operation(summary = "Cancelar una visita")
	@PutMapping("/{id}/cancelar")
	public VisitaResponseDTO cancelar(@PathVariable Long id) {
		return service.cancelar(id);
	}
	
	@Operation(summary = "Finalizar una visita")
	@PutMapping("/{id}/finalizar")
	public VisitaResponseDTO complatar(@PathVariable Long id) {
		return service.completar(id);
	}
	
	@Operation(summary = "Eliminar una visita")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		service.eliminar(id);
	}

}
