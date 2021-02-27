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
public class Ordem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne (targetEntity = Equipamento.class, fetch = FetchType.LAZY)
	@JoinColumn (name = "EquipamentoId", nullable=true)
	private Equipamento equipamentoId;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	private StatusOrdem status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipamento getEquipamentoId() {
		return equipamentoId;
	}

	public void setEquipamentoId(Equipamento equipamentoId) {
		this.equipamentoId = equipamentoId;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public StatusOrdem getStatus() {
		return status;
	}

	public void setStatus(StatusOrdem status) {
		this.status = status;
	}
	
	
}
