package com.br.ordemservico.ordemservico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.ordemservico.ordemservico.controller.dto.ClienteDTO;
import com.br.ordemservico.ordemservico.controller.form.ClienteForm;
import com.br.ordemservico.ordemservico.models.Clientes;
import com.br.ordemservico.ordemservico.repositories.ClienteRepository;


@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	@RequestMapping(value="/consultarClientePorId", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTO> lista(Long clienteId) {
		
		ClienteDTO cliente = null;
		
		cliente = clienteRepository.consultaClientePorId(clienteId);
		
		if (cliente == null) {
			return ResponseEntity.noContent().build();
		} else {
			 return ResponseEntity.ok(cliente);
		}
	} 
	
	
	@RequestMapping(value="/cadastrarCliente", method = RequestMethod.POST)
	public ResponseEntity<ClienteDTO> gravar(@RequestBody ClienteForm cliente) {
		
		ClienteDTO c = new ClienteDTO();
		
		Clientes clienteEntity = c.converte(cliente);
		clienteRepository.save(clienteEntity);
		
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	 

}
