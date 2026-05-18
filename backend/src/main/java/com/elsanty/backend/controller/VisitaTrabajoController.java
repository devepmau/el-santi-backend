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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elsanty.backend.dto.TrabajoResponseDTO;
import com.elsanty.backend.dto.VisitaTrabajoRequestDTO;
import com.elsanty.backend.dto.VisitaTrabajoResponseDTO;
import com.elsanty.backend.dto.VisitaTrabajoUpdateDTO;
import com.elsanty.backend.service.VisitaTrabajoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/visitas-trabajos")
@CrossOrigin(origins = "http://localhost:3000")
public class VisitaTrabajoController {
	
	private final VisitaTrabajoService service;
	
	public VisitaTrabajoController(VisitaTrabajoService service) {
		this.service = service;
	}
	
	@Operation(summary = "Obtener visita-trabajo por ID")
	@GetMapping("/{id}")
	public VisitaTrabajoResponseDTO obtenerPorId(@PathVariable Long id) {
		return service.obtenerPorId(id);
	}
	
	@Operation(summary = "Listar todas las visitas-trabajos")
	@GetMapping
	public List<VisitaTrabajoResponseDTO> listar(){
		return service.listar();
	}
	
	@Operation(summary = "Obtener trabajos de una visita por ID de visita")
	@GetMapping("/visita/{visitaId}")
	public List<TrabajoResponseDTO> obtenerTrabajosPorVisitaId(@PathVariable Long visitaId){
		return service.obtenerTrabajosPorVisitaId(visitaId);
	}
	
	@Operation(summary = "Crear una nueva visita-trabajo")
	@PostMapping
	public VisitaTrabajoResponseDTO crear(@Valid @RequestBody VisitaTrabajoRequestDTO dto) {
		return service.crear(dto);
	}
	
	@Operation(summary = "Actualizar una visita-trabajo existente")
	@PutMapping("/{id}")
	public VisitaTrabajoResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody VisitaTrabajoUpdateDTO dto) {
		return service.actualizat(id, dto);
	}
	
	@Operation(summary = "Actualiar la cantidad de una visita-trabajo")
	@PutMapping("/{id}/cantidad")
	public VisitaTrabajoResponseDTO modificarCantidad(@PathVariable Long id, @RequestParam Integer cantidad) {
	    return service.modificarCantidad(id, cantidad);
	}
	
	@Operation(summary = "Eliminar una visita-trabajo")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		service.eliminar(id);
	}
	
	@Operation(summary = "Eliminar todos los trabajos de una visita")
	@DeleteMapping("/{visitaId}/items")
	public void eliminarItemsDeVisita(@PathVariable Long visitaId) {
	    service.eliminarItemsDeVisita(visitaId);
	}

}
