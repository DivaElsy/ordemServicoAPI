package com.br.ordemservico.ordemservico.controller.dto;

import java.io.Serializable;

import com.br.ordemservico.ordemservico.controller.form.ClienteForm;
import com.br.ordemservico.ordemservico.models.Clientes;

public class ClienteDTO implements Serializable{
	
	private Long id;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	
	public ClienteDTO() {
	}

	public ClienteDTO(Long id, String nome, String endereco, String telefone, String email) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}
	
	public Clientes converte(ClienteForm c) {
		Clientes cliente = new Clientes();
		cliente.setNome(c.getNome());
		cliente.setEmail(c.getEmail());
		cliente.setEndereco(c.getEndereco());
		cliente.setTelefone(c.getTelefone());
		
		return cliente;
	}
}
