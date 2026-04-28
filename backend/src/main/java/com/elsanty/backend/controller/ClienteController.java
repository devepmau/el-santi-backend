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

import com.elsanty.backend.dto.ClienteRequestDTO;
import com.elsanty.backend.dto.ClienteResponseDTO;
import com.elsanty.backend.dto.ClienteUpdateDTO;
import com.elsanty.backend.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {
	
	private final ClienteService service;
	
	public ClienteController(ClienteService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ClienteResponseDTO obtenerPorId(@PathVariable Long id) {
		return service.obtenerPorId(id);
	}
	
	@GetMapping
	public List<ClienteResponseDTO> listar(){
		return service.listar();
	}
	
	@PostMapping
	public ClienteResponseDTO crear(@Valid @RequestBody ClienteRequestDTO dto) {
		return service.crear(dto);
	}
	
	@PutMapping("/{id}")
	public ClienteResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody ClienteUpdateDTO dto) {
		return service.actualizar(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		service.eliminar(id);
	}

}
