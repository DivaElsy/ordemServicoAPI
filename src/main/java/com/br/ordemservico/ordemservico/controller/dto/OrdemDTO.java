package com.br.ordemservico.ordemservico.controller.dto;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.br.ordemservico.ordemservico.controller.form.OrdemForm;
import com.br.ordemservico.ordemservico.models.Equipamento;
import com.br.ordemservico.ordemservico.models.Ordem;
import com.br.ordemservico.ordemservico.models.Ordem_Andamento;
import com.br.ordemservico.ordemservico.models.StatusOrdem;

public class OrdemDTO {
	
	private Long id;
	private Long clienteId;
	private String clienteNome;
	private Long equipamentoId;
	private String equipamentoDesc;
	private Date dataInicio;
	private Date dataFim;
	private StatusOrdem status;
	private List<OrdemAndamentoDTO> andamento;
	
	public OrdemDTO() {

	}

	public OrdemDTO(Long id, Long clienteId, String clienteNome, Long equipamentoId, String equipamentoDesc,
			Date dataInicio, Date dataFim, StatusOrdem status) {
		this.id = id;
		this.clienteId = clienteId;
		this.clienteNome = clienteNome;
		this.equipamentoId = equipamentoId;
		this.equipamentoDesc = equipamentoDesc;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.status = status;
	}

	public Long getId() {
		return id;
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

	public String getEquipamentoDesc() {
		return equipamentoDesc;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public StatusOrdem getStatus() {
		return status;
	}
	
	public void setAndamento(List<OrdemAndamentoDTO> andamento) {
		this.andamento = andamento;
	}
	
	public List<OrdemAndamentoDTO> getAndamento() {
		return andamento;
	}
	
	public Ordem converte(OrdemForm o, Equipamento e) {
		
		Ordem ordem = new Ordem();
		ordem.setEquipamentoId(e);
		ordem.setDataInicio(Calendar.getInstance().getTime());
		ordem.setStatus(StatusOrdem.RECEBIDA);
		
		return ordem;
	}
	
	public Ordem atualizaOrdem(OrdemDTO o, Equipamento e, StatusOrdem status) {
		Ordem ordem = new Ordem();
		ordem.setId(o.getId());
		ordem.setDataInicio(o.getDataInicio());
		ordem.setEquipamentoId(e);
		if (status == StatusOrdem.ENTREGUE) {
			ordem.setDataFim(Calendar.getInstance().getTime());
		}	
		ordem.setStatus(status);
	
		return ordem;
	}
	
}
