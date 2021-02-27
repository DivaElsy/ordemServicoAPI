package com.br.ordemservico.ordemservico.controller.form;

import com.br.ordemservico.ordemservico.controller.dto.EquipamentoDTO;
import com.br.ordemservico.ordemservico.models.Clientes;
import com.br.ordemservico.ordemservico.models.Equipamento;

public class EquipamentoForm {
	
	private Long clienteId;
	private String descricao;
	private String tipo;
	private String marca;
	private String problema;
	
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	
	public Equipamento converte(EquipamentoDTO e) {
		Equipamento equipamento = new Equipamento();
		equipamento.setId(e.getId());
		equipamento.setDescricao(e.getDescricao());
		equipamento.setTipo(e.getTipo());
		equipamento.setMarca(e.getMarca());
		equipamento.setProblema(e.getProblema());
		
		return equipamento;
	}
	
	
}
