package com.br.ordemservico.ordemservico.controller.form;

import java.util.Date;

public class OrdemAndamentoForm {
	
	private Long ordemId;
	private String responsavel;
	private String descricao;
	
	public Long getOrdemId() {
		return ordemId;
	}
	public void setOrdemId(Long ordemId) {
		this.ordemId = ordemId;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
