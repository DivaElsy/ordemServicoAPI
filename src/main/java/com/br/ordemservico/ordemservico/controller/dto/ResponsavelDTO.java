package com.br.ordemservico.ordemservico.controller.dto;

import com.br.ordemservico.ordemservico.controller.form.ClienteForm;
import com.br.ordemservico.ordemservico.models.Clientes;
import com.br.ordemservico.ordemservico.models.Responsavel;

public class ResponsavelDTO {
	
	private Long id;
	private String nome;
	
	public ResponsavelDTO() {
	}

	public ResponsavelDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public Responsavel converte(String nome) {
		Responsavel responsavel = new Responsavel();
		responsavel.setNome(nome);
		
		return responsavel;
	}
}
