package com.br.ordemservico.ordemservico.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Equipamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne (targetEntity = Clientes.class, fetch = FetchType.LAZY)
	@JoinColumn (name = "ClienteId", nullable=true)
	private Clientes clienteId;
	
	private String descricao;
	private String tipo;
	private String marca;
	private String problema;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Clientes getClienteId() {
		return clienteId;
	}
	public void setClienteId(Clientes clienteId) {
		this.clienteId = clienteId;
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
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
