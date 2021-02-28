package com.br.ordemservico.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.ordemservico.ordemservico.controller.dto.ClienteDTO;
import com.br.ordemservico.ordemservico.models.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {
	
	@Query
	("    select new com.br.ordemservico.ordemservico.controller.dto.ClienteDTO("
			+ "cli.id, cli.nome, cli.endereco, cli.telefone, cli.email) "
			+ " from Clientes cli "
			+ " where cli.id = :clienteId"
			)
	
	ClienteDTO consultaClientePorId(@Param("clienteId") Long clienteId);
	
	
	
}
