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

import com.elsanty.backend.dto.TrabajoRequestDTO;
import com.elsanty.backend.dto.TrabajoResponseDTO;
import com.elsanty.backend.dto.TrabajoUpdateDTO;
import com.elsanty.backend.service.TrabajoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/trabajos")
@CrossOrigin(origins = "http://localhost:3000")
public class TrabajoController {
	
	private final TrabajoService service;
	
	public TrabajoController(TrabajoService service) {
		this.service = service;
	}
	
	@Operation(summary = "Obtener trabajo por ID")
	@GetMapping("/{id}")
	public TrabajoResponseDTO obtenerPorId(@PathVariable Long id) {
		return service.obtenerPorId(id);
	}
	
	@Operation(summary = "Listar todos los trabajos")
	@GetMapping
	public List<TrabajoResponseDTO> listar(){
		return service.listar();
	}
	
	@Operation(summary = "Crear un nuevo trabajo")
	@PostMapping
	public TrabajoResponseDTO crear(@Valid @RequestBody TrabajoRequestDTO dto) {
		return service.crear(dto);
	}
	
	@Operation(summary = "Actualizar un trabajo existente")
	@PutMapping("/{id}")
	public TrabajoResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody TrabajoUpdateDTO dto) {
		return service.actualizar(id, dto);
	}
	
	@Operation(summary = "Desactivar un trabajo")
	@PutMapping("/{id}/desactivar")
	public TrabajoResponseDTO desactivar(@PathVariable Long id) {
		return service.desactivar(id);
	}
	
	@Operation(summary = "Eliminar un trabajo")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		service.eliminar(id);
	}

}
