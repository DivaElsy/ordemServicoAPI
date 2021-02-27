package com.br.ordemservico.ordemservico.controller.dto;

import java.util.Calendar;
import java.util.Date;

import com.br.ordemservico.ordemservico.controller.form.OrdemAndamentoForm;
import com.br.ordemservico.ordemservico.models.Ordem;
import com.br.ordemservico.ordemservico.models.Ordem_Andamento;

public class OrdemAndamentoDTO {
	
	private Long id;
	private Long ordemId;
	private String responsavel;
	private Date dataOcorrencia;
	private String descricao;
	
	public OrdemAndamentoDTO() {

	}

	public OrdemAndamentoDTO(Long id, String responsavel, Date dataOcorrencia, String descricao, Long ordemId) {
		this.id = id;
		this.responsavel = responsavel;
		this.dataOcorrencia = dataOcorrencia;
		this.descricao = descricao;
		this.ordemId = ordemId;
	}

	public Long getId() {
		return id;
	}
	public Long getOrdemId() {
		return ordemId;
	}
	
	public String getResponsavel() {
		return responsavel;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
	
	public Ordem_Andamento converte(OrdemAndamentoForm ordemAndamentoForm, Ordem o) {
		
		Ordem_Andamento ordemAndamento = new Ordem_Andamento();
		ordemAndamento.setOrdemId(o);
		ordemAndamento.setResponsavel(ordemAndamentoForm.getResponsavel());
		ordemAndamento.setDataOcorrencia(Calendar.getInstance().getTime());
		ordemAndamento.setDescricao(ordemAndamentoForm.getDescricao());
		
		return ordemAndamento;
	}
	
	
}
