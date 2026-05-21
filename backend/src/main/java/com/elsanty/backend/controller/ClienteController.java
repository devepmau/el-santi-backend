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

import com.elsanty.backend.dto.request.ClienteRequestDTO;
import com.elsanty.backend.dto.response.ClienteResponseDTO;
import com.elsanty.backend.dto.update.ClienteUpdateDTO;
import com.elsanty.backend.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {
	
	private final ClienteService service;
	
	public ClienteController(ClienteService service) {
		this.service = service;
	}
	
	@Operation(summary = "Obtener cliente por ID")
	@GetMapping("/{id}")
	public ClienteResponseDTO obtenerPorId(@PathVariable Long id) {
		return service.obtenerPorId(id);
	}
	
	@Operation(summary = "Listar todos los clientes")
	@GetMapping
	public List<ClienteResponseDTO> listar(){
		return service.listar();
	}
	
	@Operation(summary = "Crear un nuevo cliente")
	@PostMapping
	public ClienteResponseDTO crear(@Valid @RequestBody ClienteRequestDTO dto) {
		return service.crear(dto);
	}
	
	@Operation(summary = "Actualizar un cliente existente")
	@PutMapping("/{id}")
	public ClienteResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody ClienteUpdateDTO dto) {
		return service.actualizar(id, dto);
	}
	
	@Operation(summary = "Desactivar un cliente")
	@PutMapping("/{id}/desactivar")
	public ClienteResponseDTO desactivar(@PathVariable Long id) {
		return service.desactivar(id);
	}
	
	@Operation(summary = "Reactivar un cliente")
	@PutMapping("/{id}/activar")
	public ClienteResponseDTO reactivar(@PathVariable Long id) {
		return service.reactivar(id);
	}
	
	@Operation(summary = "Eliminar un cliente")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		service.eliminar(id);
	}

}
