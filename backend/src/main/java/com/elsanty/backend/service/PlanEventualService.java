package com.elsanty.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.elsanty.backend.dto.request.PlanEventualRequestDTO;
import com.elsanty.backend.dto.response.PlanEventualResponseDTO;
import com.elsanty.backend.dto.update.PlanEventualUpdateDTO;
import com.elsanty.backend.enums.EstadoVisita;
import com.elsanty.backend.exception.RecursoNoEncontradoException;
import com.elsanty.backend.model.Cliente;
import com.elsanty.backend.model.PlanEventual;
import com.elsanty.backend.repository.ClienteRepository;
import com.elsanty.backend.repository.PlanEventualRepository;

import jakarta.transaction.Transactional;

@Service
public class PlanEventualService {
	
	private final String PLAN_NO_ENCONTRADO = "Plan eventual no encontrado";
	
	private final PlanEventualRepository repo;
	private final ClienteRepository clienteRepo;
	
	public PlanEventualService(PlanEventualRepository repo, ClienteRepository clienteRepo) {
		this.repo = repo;
		this.clienteRepo = clienteRepo;
	}
	
	public PlanEventualResponseDTO obtenerPorId(Long id) {
		PlanEventual pe = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.PLAN_NO_ENCONTRADO));
		
		return toDTO(pe);
	}
	
	public List<PlanEventualResponseDTO> listar(){
		return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	@Transactional
	public PlanEventualResponseDTO crear(PlanEventualRequestDTO dto) {
		PlanEventual pe = new PlanEventual();
		
		Cliente cliente = clienteRepo.findById(dto.clienteId)
				.orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado"));
		
		if(!cliente.isActivo()) {
			throw new RecursoNoEncontradoException("Cliente no esta activo");
		}
		
		if (dto.fechaDeFin.isBefore(dto.fechaDeInicio)) {
		    throw new IllegalArgumentException(
		    		"La fecha de fin no puede ser anterior a la fecha de inicio"
		    		);
		}
		
		pe.setCliente(cliente);
		pe.setFechaDeInicio(dto.fechaDeInicio);
		pe.setFechaDeFin(dto.fechaDeFin);
		pe.setPrecio(dto.precio);
		pe.setEstado(EstadoVisita.PENDIENTE);
		
		return toDTO(repo.save(pe));
	}
	
	@Transactional
	public PlanEventualResponseDTO actualizar(Long id ,PlanEventualUpdateDTO dto) {
		PlanEventual pe = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.PLAN_NO_ENCONTRADO));
		
		Cliente cliente = clienteRepo.findById(dto.clienteId)
				.orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado"));
		
		if(!cliente.isActivo()) {
			throw new RecursoNoEncontradoException("Cliente no esta activo");
		}
		
		if(dto.fechaDeFin.isBefore(dto.fechaDeInicio)) {
			throw new IllegalArgumentException(
					"La fecha de fin no puede ser anterior a la fecha de inicio"
					);
		}
		
		pe.setCliente(cliente);
		pe.setFechaDeInicio(dto.fechaDeInicio);
		pe.setFechaDeFin(dto.fechaDeFin);
		pe.setPrecio(dto.precio);
		pe.setEstado(dto.estado);
		
		return toDTO(repo.save(pe));
	}
	
	@Transactional
	public PlanEventualResponseDTO cancelar(Long id) {
		PlanEventual pe = repo.findById(id)
				.orElseThrow(() -> new RecursoNoEncontradoException(this.PLAN_NO_ENCONTRADO));
		
		pe.setFechaDeFin(LocalDate.now());
		pe.setEstado(EstadoVisita.CANCELADA);
		
		return toDTO(repo.save(pe));
	}
	
	@Transactional
	public PlanEventualResponseDTO finalizar(Long id) {
		PlanEventual pe = repo.findById(id)
				.orElseThrow(() -> new RecursoNoEncontradoException(this.PLAN_NO_ENCONTRADO));
		
		pe.setFechaDeFin(LocalDate.now());
		pe.setEstado(EstadoVisita.REALIZADA);
		
		return toDTO(repo.save(pe));
	}
	
	@Transactional
	public PlanEventualResponseDTO reactivar(Long id, LocalDate fechaNueva) {
		PlanEventual pe = repo.findById(id)
				.orElseThrow(() -> new RecursoNoEncontradoException(this.PLAN_NO_ENCONTRADO));

		if (pe.getEstado() != EstadoVisita.CANCELADA) {
			throw new IllegalArgumentException("Solo se pueden reactivar planes cancelados");
		}
		
		if(fechaNueva.isBefore(pe.getFechaDeInicio())) {
			throw new IllegalArgumentException(
					"La fecha de fin no puede ser anterior a la fecha de inicio"
					);
		}

		pe.setFechaDeFin(fechaNueva);
		pe.setEstado(EstadoVisita.PENDIENTE);

		return toDTO(repo.save(pe));
	}
	
	@Transactional
	public PlanEventualResponseDTO reprogramar(Long id, LocalDate fechaInicio, LocalDate fechaFin) {
		PlanEventual pe = repo.findById(id)
				.orElseThrow(() -> new RecursoNoEncontradoException(this.PLAN_NO_ENCONTRADO));
		if(fechaFin.isBefore(fechaInicio)) {
			throw new IllegalArgumentException(
					"La fecha de fin no puede ser anterior a la fecha de inicio"
					);
		}
		
		pe.setFechaDeInicio(fechaInicio);
		pe.setFechaDeFin(fechaFin);
		pe.setEstado(EstadoVisita.PENDIENTE);
		
		return toDTO(repo.save(pe));
	}
	
	@Transactional
	public void eliminar(Long id) {
		if(!repo.existsById(id)) {
			throw new RecursoNoEncontradoException(this.PLAN_NO_ENCONTRADO);
		}
		
		repo.deleteById(id);
	}
	
	public PlanEventualResponseDTO toDTO(PlanEventual pe) {
		PlanEventualResponseDTO dto = new PlanEventualResponseDTO();
		
		dto.id = pe.getId();
		dto.clienteId = pe.getCliente().getId();
		dto.clienteNombre = pe.getCliente().getNombre();
		dto.clienteActivo = pe.getCliente().isActivo();
		dto.fechaInicio = pe.getFechaDeInicio();
		dto.fechaDeFin = pe.getFechaDefin();
		dto.precio = pe.getPrecio();
		dto.estado = pe.getEstado();
		
		return dto;
	}

}
