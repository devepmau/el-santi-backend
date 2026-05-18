package com.elsanty.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.elsanty.backend.dto.TrabajoResponseDTO;
import com.elsanty.backend.dto.VisitaTrabajoRequestDTO;
import com.elsanty.backend.dto.VisitaTrabajoResponseDTO;
import com.elsanty.backend.dto.VisitaTrabajoUpdateDTO;
import com.elsanty.backend.exception.RecursoNoEncontradoException;
import com.elsanty.backend.model.Trabajo;
import com.elsanty.backend.model.Visita;
import com.elsanty.backend.model.VisitaTrabajo;
import com.elsanty.backend.repository.TrabajoRepository;
import com.elsanty.backend.repository.VisitaRepository;
import com.elsanty.backend.repository.VisitaTrabajoRepository;

import jakarta.transaction.Transactional;

@Service
public class VisitaTrabajoService {
	
	private final String VISITA_TRABAJO_NO_ENCONTRADA = "Visita-Trabajo no encontrada";
	
	private final VisitaTrabajoRepository repo;
	
	private final VisitaRepository visitaRepo;
	
	private final TrabajoRepository trabajoRepo;
	
	public VisitaTrabajoService(VisitaTrabajoRepository repo, VisitaRepository visitaRepo, TrabajoRepository trabajoRepo) {
		this.repo = repo;
		this.visitaRepo = visitaRepo;
		this.trabajoRepo = trabajoRepo;
	}
	
	public VisitaTrabajoResponseDTO obtenerPorId(Long id) {
		VisitaTrabajo vt = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.VISITA_TRABAJO_NO_ENCONTRADA));
		
		return toDTO(vt);
	}
	
	public List<VisitaTrabajoResponseDTO> listar(){
		return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public List<TrabajoResponseDTO> obtenerTrabajosPorVisitaId(Long visitaId) {

	    return repo.findByVisitaId(visitaId)
	            .stream()
	            .map(VisitaTrabajo::getTrabajo)
	            .map(this::trabajoToDTO)
	            .toList();
	}
	
	@Transactional
	public VisitaTrabajoResponseDTO crear(VisitaTrabajoRequestDTO dto) {
		VisitaTrabajo vt = new VisitaTrabajo();
		
		Visita v = visitaRepo.findById(dto.visitaId)
				.orElseThrow(() -> new RecursoNoEncontradoException("Visita no encontrada"));
		
		Trabajo t = trabajoRepo.findById(dto.trabajoId)
				.orElseThrow(() -> new RecursoNoEncontradoException("Trabajo no encontrado"));
		
		vt.setVisita(v);
		vt.setTrabajo(t);
		vt.setCantidad(dto.cantidad);
		vt.setPrecioAplicado(dto.precioAplicado);
		
		return toDTO(repo.save(vt));
	}
	
	@Transactional
	public VisitaTrabajoResponseDTO actualizat(Long id, VisitaTrabajoUpdateDTO dto) {
		VisitaTrabajo vt = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.VISITA_TRABAJO_NO_ENCONTRADA));
		
		Visita v = visitaRepo.findById(dto.visitaId)
				.orElseThrow(() -> new RecursoNoEncontradoException("Visita no encontrada"));
		
		Trabajo t = trabajoRepo.findById(dto.trabajoId)
				.orElseThrow(() -> new RecursoNoEncontradoException("Trabajo no encontrado"));
		
		vt.setVisita(v);
		vt.setTrabajo(t);
		vt.setCantidad(dto.cantidad);
		vt.setPrecioAplicado(dto.precioAplicado);
		
		return toDTO(repo.save(vt));
	}
	
	@Transactional
	public VisitaTrabajoResponseDTO modificarCantidad(Long id, Integer cantidad) {
		VisitaTrabajo vt = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.VISITA_TRABAJO_NO_ENCONTRADA));
		
		vt.setCantidad(cantidad);
		
		return toDTO(repo.save(vt));
	}
	
	@Transactional
	public void eliminar(Long id) {
		if(!repo.existsById(id)) {
			throw new RecursoNoEncontradoException(this.VISITA_TRABAJO_NO_ENCONTRADA);
		}
		
		repo.deleteById(id);
	}
	
	@Transactional
	public void eliminarItemsDeVisita(Long visitaId) {
		repo.deleteByVisitaId(visitaId);
	}
	
	private VisitaTrabajoResponseDTO toDTO(VisitaTrabajo vt) {
		VisitaTrabajoResponseDTO dto = new VisitaTrabajoResponseDTO();
		
		dto.id = vt.getId();
		dto.visitaId = vt.getVisita().getId();
		dto.VisitaFecha = vt.getVisita().getFecha();
		dto.trabajoId = vt.getTrabajo().getId();
		dto.trabajoNombre = vt.getTrabajo().getNombre();
		dto.trabajoPrecio = vt.getTrabajo().getPrecio();
		dto.cantidad = vt.getCantidad();
		dto.precioAplicado = vt.getPrecioAplicado();
		
		return dto;
	}
	
	private TrabajoResponseDTO trabajoToDTO(Trabajo t) {
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
