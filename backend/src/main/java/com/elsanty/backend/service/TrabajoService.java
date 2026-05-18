package com.elsanty.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.elsanty.backend.dto.TrabajoRequestDTO;
import com.elsanty.backend.dto.TrabajoResponseDTO;
import com.elsanty.backend.dto.TrabajoUpdateDTO;
import com.elsanty.backend.exception.RecursoNoEncontradoException;
import com.elsanty.backend.model.Trabajo;
import com.elsanty.backend.repository.TrabajoRepository;

import jakarta.transaction.Transactional;

@Service
public class TrabajoService {
	
	private final String TRABAJO_NO_ENCONTRADO = "Trabajo no encontrado";
	
	private final TrabajoRepository repo;
	
	public TrabajoService(TrabajoRepository repo) {
		this.repo = repo;
	}
	
	public TrabajoResponseDTO obtenerPorId(Long id) {
		Trabajo t = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.TRABAJO_NO_ENCONTRADO));
		
		return toDTO(t);
	}
	
	public List<TrabajoResponseDTO> listar(){
		return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	@Transactional
	public TrabajoResponseDTO crear(TrabajoRequestDTO dto) {
		Trabajo t = new Trabajo();
		
		t.setNombre(dto.nombre);
		t.setDescripcion(dto.descripcion);
		t.setCategoria(dto.categoria);
		t.setPrecio(dto.precio);
		t.setActivo(true);
		
		return toDTO(repo.save(t));
	}
	
	@Transactional
	public TrabajoResponseDTO actualizar(Long id, TrabajoUpdateDTO dto) {
		Trabajo t = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.TRABAJO_NO_ENCONTRADO));
		
		t.setNombre(dto.nombre);
		t.setDescripcion(dto.descripcion);
		t.setCategoria(dto.categoria);
		t.setPrecio(dto.precio);
		t.setActivo(dto.activo);
		
		return toDTO(repo.save(t));
	}
	
	@Transactional
	public TrabajoResponseDTO desactivar(Long id) {
		Trabajo t = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.TRABAJO_NO_ENCONTRADO));
		
		t.setActivo(false);
		
		return toDTO(repo.save(t));
	}
	
	@Transactional
	public void eliminar(Long id) {
		if(!repo.existsById(id)) {
			throw new RecursoNoEncontradoException(this.TRABAJO_NO_ENCONTRADO);
		}
		
		repo.deleteById(id);
	}
	
	private TrabajoResponseDTO toDTO(Trabajo t) {
		TrabajoResponseDTO dto = new TrabajoResponseDTO();
		
		dto.id = t.getId();
		dto.nombre = t.getNombre();
		dto.descripcion = t.getDescripcion();
		dto.categoria = t.getCategoria();
		dto.precio = t.getPrecio();
		dto.activo = t.isActivo();
		
		return dto;
	}

}
