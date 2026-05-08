package com.elsanty.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elsanty.backend.model.Trabajo;

public interface TrabajoRepository extends JpaRepository<Trabajo, Long> {

}
