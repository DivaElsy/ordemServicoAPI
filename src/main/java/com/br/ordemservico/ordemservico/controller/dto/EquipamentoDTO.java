package com.br.ordemservico.ordemservico.controller.dto;

import java.io.Serializable;

import com.br.ordemservico.ordemservico.controller.form.EquipamentoForm;
import com.br.ordemservico.ordemservico.models.Clientes;
import com.br.ordemservico.ordemservico.models.Equipamento;

public class EquipamentoDTO implements Serializable {
	
	private Long id;
	private String cliente;
	private String descricao;
	private String tipo;
	private String marca;
	private String problema;
	
	
	public EquipamentoDTO() {
	}

	public EquipamentoDTO(Long id, String descricao, String tipo, String marca, String problema, String cliente) {
		this.id = id;
		this.descricao = descricao;
		this.cliente = cliente;
		this.tipo = tipo;
		this.marca = marca;
		this.problema = problema;
	}

	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getClienteId() {
		return cliente;
	}

	public String getTipo() {
		return tipo;
	}

	public String getMarca() {
		return marca;
	}

	public String getProblema() {
		return problema;
	}
	
	public Equipamento converte(EquipamentoForm e, Clientes c) {
		
		Equipamento equipamento = new Equipamento();
		
		equipamento.setClienteId(c);
		equipamento.setDescricao(e.getDescricao());
		equipamento.setTipo(e.getTipo());
		equipamento.setMarca(e.getMarca());
		equipamento.setProblema(e.getProblema());
		
		return equipamento;
	}
}
