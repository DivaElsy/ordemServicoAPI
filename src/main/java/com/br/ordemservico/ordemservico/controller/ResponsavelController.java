package com.br.ordemservico.ordemservico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.ordemservico.ordemservico.controller.dto.ClienteDTO;
import com.br.ordemservico.ordemservico.controller.dto.ResponsavelDTO;
import com.br.ordemservico.ordemservico.controller.form.ClienteForm;
import com.br.ordemservico.ordemservico.models.Clientes;
import com.br.ordemservico.ordemservico.models.Responsavel;
import com.br.ordemservico.ordemservico.repositories.ResponsavelRepository;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {
	
	@Autowired
	ResponsavelRepository responsavelRepository;
	
	@RequestMapping(value="/cadastrarResponsavel", method = RequestMethod.POST)
	public ResponseEntity<ResponsavelDTO> gravar(String nome) {
		
		ResponsavelDTO r = new ResponsavelDTO();
		
		Responsavel responsavelEntity = r.converte(nome);
		responsavelRepository.save(responsavelEntity);
		
		return new ResponseEntity<>(r, HttpStatus.OK);
		
	}
}
