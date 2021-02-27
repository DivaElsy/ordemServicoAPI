package com.br.ordemservico.ordemservico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.ordemservico.ordemservico.controller.dto.OrdemAndamentoDTO;
import com.br.ordemservico.ordemservico.models.Ordem_Andamento;

@Repository
public interface OrdemAndamentoRepository extends JpaRepository<Ordem_Andamento, Long>{
	
	@Query
	("    select new com.br.ordemservico.ordemservico.controller.dto.OrdemAndamentoDTO("
			+ "oan.id, oan.responsavel, oan.dataOcorrencia, oan.descricao, ord.id) "
			+ " from Ordem_Andamento oan "
			+ " inner join oan.ordemId ord "
			+ " where ord.id = :ordemId"
			)
	
	List<OrdemAndamentoDTO> consultaOcorrenciasDaOrdem(@Param("ordemId") Long ordemId);
}
