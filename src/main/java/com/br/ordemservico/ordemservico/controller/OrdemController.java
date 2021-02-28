package com.br.ordemservico.ordemservico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.ordemservico.ordemservico.controller.dto.OrdemAndamentoDTO;
import com.br.ordemservico.ordemservico.controller.dto.OrdemDTO;
import com.br.ordemservico.ordemservico.controller.form.EquipamentoForm;
import com.br.ordemservico.ordemservico.controller.form.OrdemForm;
import com.br.ordemservico.ordemservico.models.Equipamento;
import com.br.ordemservico.ordemservico.models.Ordem;
import com.br.ordemservico.ordemservico.models.Ordem_Andamento;
import com.br.ordemservico.ordemservico.models.StatusOrdem;
import com.br.ordemservico.ordemservico.repositories.EquipamentoRepository;
import com.br.ordemservico.ordemservico.repositories.OrdemAndamentoRepository;
import com.br.ordemservico.ordemservico.repositories.OrdemRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Ordem")
@RestController
@RequestMapping("/ordem")
public class OrdemController {
	
	@Autowired
	OrdemRepository ordemRepository;
	
	@Autowired
	EquipamentoRepository equipamentoRepository;
	
	@Autowired
	OrdemAndamentoRepository ordemAndamentoRepository;
	
	@ApiOperation(value = "Retorna a informação da Ordem consultada")
	@RequestMapping(value="/consultarOrdemPorId", method = RequestMethod.GET)
	public ResponseEntity<OrdemDTO> consulta(Long ordemId) {
		
		OrdemDTO ordem = null;
		
		ordem = ordemRepository.consultaOrdemPorId(ordemId);
		
		if (ordem == null) {
			return ResponseEntity.noContent().build();
		} else {
			 ordem.setAndamento(ordemAndamentoRepository.consultaOcorrenciasDaOrdem(ordemId));
			 return ResponseEntity.ok(ordem);
		}
	}
	
	@ApiOperation(notes = "Grava a ordem na tabela Ordem", value = "ordem")
	@RequestMapping(value="/cadastrarOrdem", method = RequestMethod.POST)
	public ResponseEntity<OrdemDTO> gravar(@RequestBody OrdemForm ordem) {
		
		EquipamentoForm e = new EquipamentoForm();
		Equipamento equipamentoEntity = new Equipamento();
		equipamentoEntity = e.converte(equipamentoRepository.consultaEquipamentoPorId(ordem.getEquipamentoId()));
		
		OrdemDTO o = new OrdemDTO();
		Ordem ordemEntity = new Ordem();
		
		ordemEntity = o.converte(ordem, equipamentoEntity);
		ordemRepository.save(ordemEntity);
		
		return new ResponseEntity<>(o, HttpStatus.OK);
	}
	
	@ApiOperation(notes = "Atualiza o status da ordem, se o status for FINALIZADA, grava a data fim com a data corrente", value = "ordem")
	@RequestMapping(value="/atualizaOrdem", method = RequestMethod.PUT)
	public ResponseEntity<OrdemDTO> atualizaOrdem(Long ordemId, StatusOrdem status) {
		
		OrdemDTO ordemDTO = new OrdemDTO();
		ordemDTO = ordemRepository.consultaOrdemPorId(ordemId);
		
		Equipamento equipamentoEntity = new Equipamento();
		EquipamentoForm e = new EquipamentoForm();
		equipamentoEntity = e.converte(equipamentoRepository.consultaEquipamentoPorId(ordemDTO.getEquipamentoId()));
		
		
		Ordem ordemEntity = new Ordem();
		ordemEntity = ordemDTO.atualizaOrdem(ordemRepository.consultaOrdemPorId(ordemId),equipamentoEntity, status);
		
		if (ordemEntity != null) {
			ordemRepository.save(ordemEntity);
			return new ResponseEntity<>(ordemDTO, HttpStatus.OK);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
		
	}
}
