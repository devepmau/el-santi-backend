package com.elsanty.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elsanty.backend.model.VisitaTrabajo;

public interface VisitaTrabajoRepository extends JpaRepository<VisitaTrabajo, Long> {
	
	void deleteByVisitaId(Long visitaId);
	List<VisitaTrabajo> findByVisitaId(Long visitaId);

}
