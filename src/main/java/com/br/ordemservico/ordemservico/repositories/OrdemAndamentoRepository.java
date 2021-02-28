package com.br.ordemservico.ordemservico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.ordemservico.ordemservico.controller.dto.OrdemAndamentoDTO;
import com.br.ordemservico.ordemservico.controller.dto.OrdemAndamentoResDTO;
import com.br.ordemservico.ordemservico.models.Ordem_Andamento;
import com.br.ordemservico.ordemservico.models.StatusOrdem;

@Repository
public interface OrdemAndamentoRepository extends JpaRepository<Ordem_Andamento, Long>{
	
	@Query
	("    select new com.br.ordemservico.ordemservico.controller.dto.OrdemAndamentoDTO("
			+ "oan.id, res.nome, oan.dataOcorrencia, oan.descricao, ord.id) "
			+ " from Ordem_Andamento oan "
			+ " inner join oan.ordemId ord "
			+ " inner join oan.responsavelId res"
			+ " where ord.id = :ordemId"
			)
	
	List<OrdemAndamentoDTO> consultaOcorrenciasDaOrdem(@Param("ordemId") Long ordemId);
	
	@Query
	("    select new com.br.ordemservico.ordemservico.controller.dto.OrdemAndamentoResDTO("
			+ "oan.id, ord.id as ordemId, res.id as responsavelId, res.nome as responsavelNome, cli.id as clienteId, cli.nome as clienteNome,"
			+ "equ.id as equipamentoId, equ.descricao as equipamentoDescricao, ord.dataInicio as dataInicioOrdem, ord.status, oan.dataOcorrencia, "
			+ "oan.descricao as descricaoOcorrencia) "
			+ " from Ordem_Andamento oan "
			+ " inner join oan.ordemId ord "
			+ " inner join oan.responsavelId res"
			+ " inner join ord.equipamentoId equ"
			+ " inner join equ.clienteId cli"
			+ " where res.id = :responsavelId"
			+ " and ord.status <> :status"
			)
	List<OrdemAndamentoResDTO> consultaOrdensPendentesPorResponsavel(@Param("responsavelId") Long responsavelId, @Param("status") StatusOrdem status);
}
