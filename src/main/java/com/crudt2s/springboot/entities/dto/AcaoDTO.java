package com.crudt2s.springboot.entities.dto;

import java.io.Serializable;
import java.util.Date;

import com.crudt2s.springboot.entities.Acao;

public class AcaoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Double valorCompra;
	private Integer quantidadeAcao;
	private Date diaCompra;
	
	public AcaoDTO() {
		
	}
	public AcaoDTO(Acao acao) {
		this.id = acao.getId();
		this.name = acao.getName();
		this.valorCompra = acao.getValorCompra();
		this.quantidadeAcao = acao.getQuantidadeAcao();
		this.diaCompra = acao.getDiaCompra();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Integer getQuantidadeAcao() {
		return quantidadeAcao;
	}
	public void setQuantidadeAcao(Integer quantidadeAcao) {
		this.quantidadeAcao = quantidadeAcao;
	}
	public Date getDiaCompra() {
		return diaCompra;
	}
	public void setDiaCompra(Date diaCompra) {
		this.diaCompra = diaCompra;
	}
	
	
	
	
}
