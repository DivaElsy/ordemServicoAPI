package com.br.ordemservico.ordemservico.controller.dto;

import java.util.Date;

import com.br.ordemservico.ordemservico.models.StatusOrdem;

public class OrdemAndamentoResDTO {
	
	private Long id;
	private Long ordemId;
	private Long responsavelId;
	private String responsavelNome;
	private Long clienteId;
	private String clienteNome;
	private Long equipamentoId;
	private String equipamentoDescricao;
	private Date dataInicioOrdem;
	private StatusOrdem status;
	private Date dataOcorrencia;
	private String descricaoOcorrencia;
	
	public OrdemAndamentoResDTO() {

	}
	
	public OrdemAndamentoResDTO(Long id, Long ordemId, Long responsavelId, String responsavelNome, Long clienteId, String clienteNome,
			Long equipamentoId, String equipamentoDescricao, Date dataInicioOrdem, StatusOrdem status, Date dataOcorrencia, 
			String descricaoOcorrencia) {
		this.id = id;
		this.ordemId = ordemId;
		this.responsavelId = responsavelId;
		this.responsavelNome = responsavelNome;
		this.clienteId = clienteId;
		this.clienteNome = clienteNome;
		this.equipamentoId = equipamentoId;
		this.equipamentoDescricao = equipamentoDescricao;
		this.dataInicioOrdem = dataInicioOrdem;
		this.status = status;
		this.dataOcorrencia = dataOcorrencia;
		this.descricaoOcorrencia = descricaoOcorrencia;
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
	
	public String getDescricaoOcorrenca() {
		return descricaoOcorrencia;
	}
	
	public Long getResponsavelId() {
		return responsavelId;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public Long getEquipamentoId() {
		return equipamentoId;
	}

	public String getEquipamentoDescricao() {
		return equipamentoDescricao;
	}

	public Date getDataInicioOrdem() {
		return dataInicioOrdem;
	}

	public StatusOrdem getStatus() {
		return status;
	}

}
