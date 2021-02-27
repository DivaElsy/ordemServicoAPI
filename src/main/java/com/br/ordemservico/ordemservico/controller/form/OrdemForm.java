package com.br.ordemservico.ordemservico.controller.form;

import java.util.Calendar;

import com.br.ordemservico.ordemservico.controller.dto.OrdemDTO;
import com.br.ordemservico.ordemservico.models.Equipamento;
import com.br.ordemservico.ordemservico.models.Ordem;
import com.br.ordemservico.ordemservico.models.StatusOrdem;

public class OrdemForm {
	
	private Long equipamentoId;

	public Long getEquipamentoId() {
		return equipamentoId;
	}

	public void setEquipamentoId(Long equipamentoId) {
		this.equipamentoId = equipamentoId;
	}
	
	public Ordem converte(OrdemDTO o) {
		Ordem ordem = new Ordem();
		ordem.setId(o.getId());
		ordem.setDataInicio(o.getDataInicio());
		ordem.setDataFim(o.getDataFim());
		ordem.setStatus(o.getStatus());
	
		return ordem;
	}
	
	public Ordem atualizaOrdem(OrdemDTO o, StatusOrdem status) {
		Ordem ordem = new Ordem();
		ordem.setId(o.getId());
		ordem.setDataFim(Calendar.getInstance().getTime());
		ordem.setStatus(status);
	
		return ordem;
	}
}
