package com.elsanty.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.elsanty.backend.dto.ClienteRequestDTO;
import com.elsanty.backend.dto.ClienteResponseDTO;
import com.elsanty.backend.dto.ClienteUpdateDTO;
import com.elsanty.backend.exception.RecursoNoEncontradoException;
import com.elsanty.backend.model.Cliente;
import com.elsanty.backend.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final String CLIENTE_NO_ENCONTRADO = "Cliente no encontrado";
	
	private final ClienteRepository repo;
	
	public ClienteService(ClienteRepository repo) {
		this.repo = repo;
	}
	
	public ClienteResponseDTO obtenerPorId(Long id) {
		Cliente c = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.CLIENTE_NO_ENCONTRADO));
		
		return toDTO(c);
	}
	
	public List<ClienteResponseDTO> listar(){
		return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public ClienteResponseDTO crear(ClienteRequestDTO dto) {
		Cliente c = new Cliente();
		
		c.setFechaAlta(LocalDate.now());
		c.setNombre(dto.nombre);
		c.setTelefono(dto.telefono);
		c.setCorreoElectronico(dto.correoElectronico);
		c.setProvincia(dto.provincia);
		c.setLocalidad(dto.localidad);
		c.setBarrioPrivado(dto.barrioPrivado);
		c.setDireccion(dto.direccion);
		c.setBarrio(dto.barrio);
		c.setLote(dto.lote);
		c.setPreferenciaCorte(dto.preferenciaCorte);
		c.setPreferenciaHoraria(dto.preferenciaHoraria);
		c.setPreferenciaSemanal(dto.preferenciaSemanal);
		c.setPrioridad(dto.prioridad);
		c.setObservaciones(dto.observaciones);
		c.setActivo(true);
		
		return toDTO(repo.save(c));
	}
	
	public ClienteResponseDTO actualizar(Long id, ClienteUpdateDTO dto) {
		Cliente c = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.CLIENTE_NO_ENCONTRADO));

		c.setNombre(dto.nombre);
		c.setTelefono(dto.telefono);
		c.setCorreoElectronico(dto.correoElectronico);
		c.setProvincia(dto.provincia);
		c.setLocalidad(dto.localidad);
		c.setBarrioPrivado(dto.barrioPrivado);
		c.setDireccion(dto.direccion);
		c.setBarrio(dto.barrio);
		c.setLote(dto.lote);
		c.setPreferenciaCorte(dto.preferenciaCorte);
		c.setPreferenciaHoraria(dto.preferenciaHoraria);
		c.setPreferenciaSemanal(dto.preferenciaSemanal);
		c.setPrioridad(dto.prioridad);
		c.setObservaciones(dto.observaciones);
		c.setActivo(dto.activo);

		return toDTO(repo.save(c));
	}
	
	public void eliminar(Long id) {
		if(!repo.existsById(id)) {
			throw new RecursoNoEncontradoException(this.CLIENTE_NO_ENCONTRADO);
		}
		
		repo.deleteById(id);
	}
	
	private ClienteResponseDTO toDTO(Cliente c) {
		ClienteResponseDTO dto = new ClienteResponseDTO();
		
		dto.id = c.getId();
		dto.fechaAlta = c.getFechaAlta();
		dto.nombre = c.getNombre();
		dto.telefono = c.getTelefono();
		dto.correoElectronico = c.getCorreoElectronico();
		dto.provincia = c.getProvincia();
		dto.localidad = c.getLocalidad();
		dto.barrioPrivado = c.isBarrioPrivado();
		dto.direccion = c.getDireccion();
		dto.barrio = c.getBarrio();
		dto.lote = c.getLote();
		dto.preferenciaCorte = c.getPreferenciaCorte();
		dto.preferenciaHoraria = c.getPreferenciaHoraria();
		dto.preferenciaSemanal = c.getPreferenciaSemanal();
		dto.prioridad = c.getPrioridad();
		dto.observaciones = c.getObservaciones();
		dto.activo = c.isActivo();
		
		return dto;
	}

}
