package com.br.ordemservico.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.ordemservico.ordemservico.controller.dto.ResponsavelDTO;
import com.br.ordemservico.ordemservico.models.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>{
	
	@Query
	("    select new com.br.ordemservico.ordemservico.controller.dto.ResponsavelDTO("
			+ "res.id, res.nome) "
			+ " from Responsavel res "
			+ " where res.id = :responsavelId"
			)
	
	ResponsavelDTO consultaResponsavelPorId(@Param("responsavelId") Long responsavelId);
}	
