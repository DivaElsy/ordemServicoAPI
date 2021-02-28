package com.br.ordemservico.ordemservico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.ordemservico.ordemservico.controller.dto.ClienteDTO;
import com.br.ordemservico.ordemservico.controller.form.ClienteForm;
import com.br.ordemservico.ordemservico.models.Clientes;
import com.br.ordemservico.ordemservico.repositories.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Clientes")
@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@RequestMapping(value="/consultarClientePorId", method = RequestMethod.GET)
	@ApiOperation(value = "Retorna a informação do Cliente consultado")
	public ResponseEntity<ClienteDTO> lista(Long clienteId) {
		
		ClienteDTO cliente = null;
		
		cliente = clienteRepository.consultaClientePorId(clienteId);
		
		if (cliente == null) {
			return ResponseEntity.noContent().build();
		} else {
			 return ResponseEntity.ok(cliente);
		}
	} 
	
	@ApiOperation(notes = "Grava um cliente na tabela Clientes", value = "cliente")
	@RequestMapping(value="/cadastrarCliente", method = RequestMethod.POST)
	public ResponseEntity<ClienteDTO> gravar(@RequestBody ClienteForm cliente) {
		
		ClienteDTO c = new ClienteDTO();
		
		Clientes clienteEntity = c.converte(cliente);
		clienteRepository.save(clienteEntity);
		
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	 

}
