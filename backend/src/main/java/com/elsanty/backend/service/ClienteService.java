package com.elsanty.backend.service;

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
		c.setNombre(dto.nombre);
		c.setTelefono(dto.telefono);
		c.setCorreoElectronico(dto.correoElectronico);
		c.setLocalidad(dto.localidad);
		c.setBarrioPrivado(dto.barrioPrivado);
		c.setDireccion(dto.direccion);
		c.setAlturaLote(dto.alturaLote);
		c.setActivo(true);
		
		return toDTO(repo.save(c));
	}
	
	public ClienteResponseDTO actualizar(Long id, ClienteUpdateDTO dto) {
		Cliente c = repo.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(this.CLIENTE_NO_ENCONTRADO));

		c.setNombre(dto.nombre);
		c.setTelefono(dto.telefono);
		c.setCorreoElectronico(dto.correoElectronico);
		c.setLocalidad(dto.localidad);
		c.setBarrioPrivado(dto.barrioPrivado);
		c.setDireccion(dto.direccion);
		c.setAlturaLote(dto.alturaLote);
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
		dto.nombre = c.getNombre();
		dto.telefono = c.getTelefono();
		dto.correoElectronico = c.getCorreoElectronico();
		dto.localidad = c.getLocalidad();
		dto.barrioPrivado = c.isBarrioPrivado();
		dto.direccion = c.getDireccion();
		dto.alturaLote = c.getAlturaLote();
		dto.activo = c.isActivo();
		return dto;
	}

}
