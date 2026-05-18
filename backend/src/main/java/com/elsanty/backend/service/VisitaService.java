package com.elsanty.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.elsanty.backend.dto.VisitaRequestDTO;
import com.elsanty.backend.dto.VisitaResponseDTO;
import com.elsanty.backend.dto.VisitaUpdateDTO;
import com.elsanty.backend.enums.EstadoVisita;
import com.elsanty.backend.exception.RecursoNoEncontradoException;
import com.elsanty.backend.model.PlanMensual;
import com.elsanty.backend.model.Visita;
import com.elsanty.backend.repository.PlanMensualRepository;
import com.elsanty.backend.repository.VisitaRepository;

import jakarta.transaction.Transactional;

@Service
public class VisitaService {
	
	private final String VISITA_NO_ENCONTRADA = "Visita no encontrada";
	
	private final VisitaRepository repo;
	
	private final PlanMensualRepository planMensualRepo;
	
	public VisitaService(VisitaRepository repo, PlanMensualRepository planMensualRepo) {
		this.repo = repo;
		this.planMensualRepo = planMensualRepo;
	}
	
	public VisitaResponseDTO obtenerPorId(Long id) {
		Visita v = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.VISITA_NO_ENCONTRADA));
		
		return toDTO(v);
	}
	
	public List<VisitaResponseDTO> listar(){
		return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	@Transactional
	public VisitaResponseDTO crear(VisitaRequestDTO dto) {
		Visita v = new Visita();
		
		PlanMensual pm = planMensualRepo.findById(dto.planMensualId)
				.orElseThrow(() -> new RecursoNoEncontradoException("Plan Mensual no encontrado"));
		
		if(!pm.isActivo()) {
			throw new RecursoNoEncontradoException("El Plan Mensual no esta activo");
		}
		
		v.setPlanMensual(pm);
		v.setFecha(dto.fecha);
		v.setEstado(EstadoVisita.PENDIENTE);
		v.setObservaciones(dto.observaciones);
		
		return toDTO(repo.save(v));
	}
	
	@Transactional
	public VisitaResponseDTO actualizar(Long id, VisitaUpdateDTO dto) {
		Visita v = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.VISITA_NO_ENCONTRADA));
		
		PlanMensual pm = planMensualRepo.findById(dto.planMensualId)
				.orElseThrow(() -> new RecursoNoEncontradoException("Plan Mensual no encontrado"));
		
		if(!pm.isActivo()) {
			throw new RecursoNoEncontradoException("El Plan Mensual no esta activo");
		}
		
		v.setPlanMensual(pm);
		v.setFecha(dto.fecha);
		v.setObservaciones(dto.observaciones);
		
		return toDTO(repo.save(v));
	}
	
	@Transactional
	public VisitaResponseDTO completar(Long id) {
		Visita v = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.VISITA_NO_ENCONTRADA));
		
		v.setEstado(EstadoVisita.REALIZADA);
		
		return toDTO(repo.save(v));
	}
	
	@Transactional
	public VisitaResponseDTO cancelar(Long id) {
		Visita v = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.VISITA_NO_ENCONTRADA));
		
		v.setEstado(EstadoVisita.CANCELADA);
		
		return toDTO(repo.save(v));
	}
	
	@Transactional
	public void eliminar(Long id) {
		if(!repo.existsById(id)) {
			throw new RecursoNoEncontradoException(this.VISITA_NO_ENCONTRADA);
		}
		
		repo.deleteById(id);
	}
	
	private VisitaResponseDTO toDTO(Visita v) {
		VisitaResponseDTO dto = new VisitaResponseDTO();
		
		dto.id = v.getId();
		dto.planMensualId = v.getPlanMensual().getId();
		dto.fecha = v.getFecha();
		dto.estado = v.getEstado();
		dto.observaciones = v.getObservaciones();
		
		return dto;
		
	}

}
