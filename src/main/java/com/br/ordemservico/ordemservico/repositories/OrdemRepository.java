package com.br.ordemservico.ordemservico.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.ordemservico.ordemservico.controller.dto.OrdemDTO;
import com.br.ordemservico.ordemservico.models.Ordem;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long>{
	
	@Query
	("    select new com.br.ordemservico.ordemservico.controller.dto.OrdemDTO("
			+ "ord.id, cli.id, cli.nome, equ.id, equ.descricao, ord.dataInicio, ord.dataFim, ord.status) "
			+ " from Ordem ord "
			+ " inner join ord.equipamentoId equ "
			+ " inner join equ.clienteId cli "
			+ " where ord.id = :ordemId"
			)
	OrdemDTO consultaOrdemPorId(@Param("ordemId") Long ordemId);
}
