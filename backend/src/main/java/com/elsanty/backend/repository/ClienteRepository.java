package com.elsanty.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elsanty.backend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
