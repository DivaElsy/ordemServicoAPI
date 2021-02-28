package com.br.ordemservico.ordemservico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.ordemservico.ordemservico.controller.dto.EquipamentoDTO;
import com.br.ordemservico.ordemservico.controller.form.ClienteForm;
import com.br.ordemservico.ordemservico.controller.form.EquipamentoForm;
import com.br.ordemservico.ordemservico.models.Clientes;
import com.br.ordemservico.ordemservico.models.Equipamento;
import com.br.ordemservico.ordemservico.repositories.ClienteRepository;
import com.br.ordemservico.ordemservico.repositories.EquipamentoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Equipamento")
@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {
	
	@Autowired
	EquipamentoRepository equipamentoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@ApiOperation(value = "Retorna a informação do Equipamento consultado")
	@RequestMapping(value="/consultarEquipamentoPorId", method = RequestMethod.GET)
	public ResponseEntity<EquipamentoDTO> lista(Long equipamentoId) {
		
		EquipamentoDTO equipamento = null;
		
		equipamento = equipamentoRepository.consultaEquipamentoPorId(equipamentoId);
		
		if (equipamento == null) {
			return ResponseEntity.noContent().build();
		} else {
			 return ResponseEntity.ok(equipamento);
		}
	}
	
	@ApiOperation(notes = "Grava um equipamento na tabela Equipamento", value = "equipamento")
	@RequestMapping(value="/cadastrarEquipamento", method = RequestMethod.POST)
	public ResponseEntity<EquipamentoDTO> gravar(@RequestBody EquipamentoForm equipamento) {
		
		ClienteForm c = new ClienteForm();
		Clientes clienteEntity = new Clientes();
		clienteEntity = c.converte(clienteRepository.consultaClientePorId(equipamento.getClienteId()));
		
		
		EquipamentoDTO e = new EquipamentoDTO();
		Equipamento equipamentoEntity = new Equipamento();
		
		equipamentoEntity = e.converte(equipamento,clienteEntity);
		equipamentoRepository.save(equipamentoEntity);
		
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
}
