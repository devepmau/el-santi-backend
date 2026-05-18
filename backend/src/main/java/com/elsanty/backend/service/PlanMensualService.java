package com.elsanty.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.elsanty.backend.dto.PlanMensualRequestDTO;
import com.elsanty.backend.dto.PlanMensualResponseDTO;
import com.elsanty.backend.dto.PlanMensualUpdateDTO;
import com.elsanty.backend.exception.RecursoNoEncontradoException;
import com.elsanty.backend.model.Cliente;
import com.elsanty.backend.model.PlanMensual;
import com.elsanty.backend.repository.ClienteRepository;
import com.elsanty.backend.repository.PlanMensualRepository;

import jakarta.transaction.Transactional;

@Service
public class PlanMensualService {
	
	private final String PLAN_NO_ENCONTRADO = "Plan mensual no encontrado";
	
	private final PlanMensualRepository repo;
	private final ClienteRepository clienteRepo;
	
	public PlanMensualService(PlanMensualRepository repo, ClienteRepository clienteRepo) {
		this.repo = repo;
		this.clienteRepo = clienteRepo;
	}
	
	public PlanMensualResponseDTO obtenerporId(Long id) {
		PlanMensual pm = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.PLAN_NO_ENCONTRADO));
		
		return toDTO(pm);
	}
	
	public List<PlanMensualResponseDTO> listar(){
		return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	@Transactional
	public PlanMensualResponseDTO crear(PlanMensualRequestDTO dto) {
		PlanMensual pm = new PlanMensual();
		
		Cliente cliente = clienteRepo.findById(dto.clienteId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado"));
		
		if(!cliente.isActivo()) {
			throw new RecursoNoEncontradoException("El cliente no esta activo");
		}
		
		pm.setCliente(cliente);
		pm.setFechaInicio(dto.fechaInicio);
		pm.setFrecuenciaMensual(dto.frecuenciaMensual);
		pm.setPrecioMensual(dto.precioMensual);
		pm.setActivo(true);
		
		return toDTO(repo.save(pm));
	}
	
	@Transactional
	public PlanMensualResponseDTO actualizar(Long id, PlanMensualUpdateDTO dto) {
		PlanMensual pm = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.PLAN_NO_ENCONTRADO));

		Cliente cliente = clienteRepo.findById(dto.clienteId)
				.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

		if (!cliente.isActivo()) {
			throw new RecursoNoEncontradoException("El cliente no esta activo");
		}

		pm.setCliente(cliente);
		pm.setFechaInicio(dto.fechaInicio);
		pm.setFrecuenciaMensual(dto.frecuenciaMensual);
		pm.setPrecioMensual(dto.precioMensual);
		pm.setActivo(dto.activo);

		return toDTO(repo.save(pm));
	}
	
	@Transactional
	public PlanMensualResponseDTO desactivar(Long id) {
		PlanMensual pm = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.PLAN_NO_ENCONTRADO));

		pm.setActivo(false);

		return toDTO(repo.save(pm));
	}
	
	@Transactional
	public void eliminar(Long id) {
		if(!repo.existsById(id)) {
			throw new RecursoNoEncontradoException(this.PLAN_NO_ENCONTRADO);
		}
		
		repo.deleteById(id);
	}
	
	private PlanMensualResponseDTO toDTO(PlanMensual pm) {
		PlanMensualResponseDTO dto = new PlanMensualResponseDTO();
		
		dto.id = pm.getId();
		dto.clienteId = pm.getCliente().getId();
		dto.clienteNombre = pm.getCliente().getNombre();
		dto.clienteActivo = pm.getCliente().isActivo();
		dto.fechaInicio = pm.getFechaInicio();
		dto.frecuenciaMensual = pm.getFrecuenciaMensual();
		dto.precioMensual = pm.getPrecioMensual();
		dto.activo = pm.isActivo();
		
		return dto;
	}
}
