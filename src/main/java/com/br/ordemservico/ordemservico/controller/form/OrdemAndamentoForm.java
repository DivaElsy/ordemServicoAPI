package com.br.ordemservico.ordemservico.controller.form;

import java.util.Date;

public class OrdemAndamentoForm {
	
	private Long ordemId;
	private Long responsavelId;
	private String descricao;
	
	public Long getOrdemId() {
		return ordemId;
	}
	public void setOrdemId(Long ordemId) {
		this.ordemId = ordemId;
	}
	public Long getResponsavelId() {
		return responsavelId;
	}
	public void setResponsavelId(Long responsavelId) {
		this.responsavelId = responsavelId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
