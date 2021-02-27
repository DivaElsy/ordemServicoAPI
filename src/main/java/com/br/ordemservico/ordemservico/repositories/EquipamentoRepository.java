package com.br.ordemservico.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.ordemservico.ordemservico.controller.dto.EquipamentoDTO;
import com.br.ordemservico.ordemservico.models.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long>{
	
	
	@Query
	("    select new com.br.ordemservico.ordemservico.controller.dto.EquipamentoDTO("
			+ "equ.id, equ.descricao, equ.tipo, equ.marca, equ.problema, cli.nome) "
			+ " from Equipamento equ "
			+ " inner join equ.clienteId cli"
			+ " where equ.id = :equipamentoId"
			)
	EquipamentoDTO consultaEquipamentoPorId(@Param("equipamentoId") Long clienteId);
}

