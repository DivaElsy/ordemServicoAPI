package com.br.ordemservico.ordemservico.controller.dto;

import java.util.Calendar;
import java.util.Date;

import com.br.ordemservico.ordemservico.controller.form.OrdemAndamentoForm;
import com.br.ordemservico.ordemservico.models.Ordem;
import com.br.ordemservico.ordemservico.models.Ordem_Andamento;
import com.br.ordemservico.ordemservico.models.Responsavel;
import com.br.ordemservico.ordemservico.models.StatusOrdem;

public class OrdemAndamentoDTO {
	
	private Long id;
	private Long ordemId;
	private String responsavelNome;
	private Date dataOcorrencia;
	private String descricao;
	
	public OrdemAndamentoDTO() {

	}

	public OrdemAndamentoDTO(Long id, String responsavelNome, Date dataOcorrencia, String descricao, Long ordemId) {
		this.id = id;
		this.responsavelNome = responsavelNome;
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
	
	public String getResponsavelNome() {
		return responsavelNome;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Ordem_Andamento converte(OrdemAndamentoForm ordemAndamentoForm, Ordem o, Responsavel r) {
		
		Ordem_Andamento ordemAndamento = new Ordem_Andamento();
		ordemAndamento.setOrdemId(o);
		ordemAndamento.setResponsavel(r);
		ordemAndamento.setDataOcorrencia(Calendar.getInstance().getTime());
		ordemAndamento.setDescricao(ordemAndamentoForm.getDescricao());
		
		return ordemAndamento;
	}
	
	
}
