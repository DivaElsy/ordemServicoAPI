package com.br.ordemservico.ordemservico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.ordemservico.ordemservico.controller.dto.OrdemAndamentoDTO;
import com.br.ordemservico.ordemservico.controller.dto.OrdemAndamentoResDTO;
import com.br.ordemservico.ordemservico.controller.form.OrdemAndamentoForm;
import com.br.ordemservico.ordemservico.controller.form.OrdemForm;
import com.br.ordemservico.ordemservico.controller.form.ResponsavelForm;
import com.br.ordemservico.ordemservico.models.Ordem;
import com.br.ordemservico.ordemservico.models.Ordem_Andamento;
import com.br.ordemservico.ordemservico.models.Responsavel;
import com.br.ordemservico.ordemservico.models.StatusOrdem;
import com.br.ordemservico.ordemservico.repositories.OrdemAndamentoRepository;
import com.br.ordemservico.ordemservico.repositories.OrdemRepository;
import com.br.ordemservico.ordemservico.repositories.ResponsavelRepository;

@RestController
@RequestMapping("/ordemAndamento")
public class OrdemAndamentoController {
	
	@Autowired
	OrdemAndamentoRepository ordemAndamentoRepository;
	
	@Autowired
	OrdemRepository ordemRepository;
	
	@Autowired
	ResponsavelRepository responsavelRepository;
	
	
	@RequestMapping(value="/consultarOcorrenciaOrdem", method = RequestMethod.GET)
	public ResponseEntity<List<OrdemAndamentoDTO>> consultarOcorrenciaOrdem(Long ordemId) {
		
		List<OrdemAndamentoDTO> ordemOcorrencias = null;
		
		ordemOcorrencias = ordemAndamentoRepository.consultaOcorrenciasDaOrdem(ordemId);
		
		if (ordemOcorrencias == null) {
			return ResponseEntity.noContent().build();
		} else {
			 return ResponseEntity.ok(ordemOcorrencias);
		}
	}
	
	@RequestMapping(value="/cadastrarOcorrenciaOrdem", method = RequestMethod.POST)
	public ResponseEntity<OrdemAndamentoDTO> gravar(@RequestBody OrdemAndamentoForm ordemAndamento) {
		
		OrdemForm o = new OrdemForm();
		Ordem ordemEntity = new Ordem();
		ordemEntity = o.converte(ordemRepository.consultaOrdemPorId(ordemAndamento.getOrdemId()));
		
		ResponsavelForm r = new ResponsavelForm();
		Responsavel responsavelEntity = new Responsavel();
		responsavelEntity = r.converte(responsavelRepository.consultaResponsavelPorId(ordemAndamento.getResponsavelId()));
		
		OrdemAndamentoDTO oa = new OrdemAndamentoDTO();
		Ordem_Andamento ordemAndamentoEntity = new Ordem_Andamento();
		
		ordemAndamentoEntity = oa.converte(ordemAndamento, ordemEntity, responsavelEntity);
		ordemAndamentoRepository.save(ordemAndamentoEntity);
		
		return new ResponseEntity<>(oa, HttpStatus.OK);
	}
	
	@RequestMapping(value="/consultaOrdensPendentesPorResponsavel", method = RequestMethod.GET)
	public ResponseEntity<List<OrdemAndamentoResDTO>> consultaOrdensPendentesPorResponsavel(Long responsavelId) {
		
		List<OrdemAndamentoResDTO> ordemOcorrencias = null;
		
		ordemOcorrencias = ordemAndamentoRepository.consultaOrdensPendentesPorResponsavel(responsavelId, StatusOrdem.FINALIZADA);
		
		if (ordemOcorrencias == null) {
			return ResponseEntity.noContent().build();
		} else {
			 return ResponseEntity.ok(ordemOcorrencias);
		}
	}
}
