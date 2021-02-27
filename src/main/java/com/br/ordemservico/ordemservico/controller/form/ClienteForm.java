package com.br.ordemservico.ordemservico.controller.form;

import com.br.ordemservico.ordemservico.controller.dto.ClienteDTO;
import com.br.ordemservico.ordemservico.models.Clientes;

public class ClienteForm {
	
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Clientes converte(ClienteDTO c) {
		Clientes cliente = new Clientes();
		cliente.setId(c.getId());
		cliente.setNome(c.getNome());
		cliente.setEmail(c.getEmail());
		cliente.setEndereco(c.getEndereco());
		cliente.setTelefone(c.getTelefone());
		
		return cliente;
	}
	
}
