package com.br.ordemservico.ordemservico.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ordem_Andamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne (targetEntity = Ordem.class, fetch = FetchType.LAZY)
	@JoinColumn (name = "OrdemId", nullable=true)
	private Ordem ordemId;
	
	@ManyToOne (targetEntity = Responsavel.class, fetch = FetchType.LAZY)
	@JoinColumn (name = "ResponsavelId", nullable=true)
	private Responsavel responsavelId;
	
	private Date dataOcorrencia;
	
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ordem getOrdemId() {
		return ordemId;
	}

	public void setOrdemId(Ordem ordemId) {
		this.ordemId = ordemId;
	}

	public Responsavel getResponsavel() {
		return responsavelId;
	}

	public void setResponsavel(Responsavel responsavelId) {
		this.responsavelId = responsavelId;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
