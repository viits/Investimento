package com.crudt2s.springboot.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_acao")
public class Acao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double valorCompra;
	private Integer quantidadeAcao;
	private Date diaCompra;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Acao() {
		
	}

	public Acao(Integer id, String name, Double valorCompra, Integer quantidadeAcao, Date diaCompra) {
		super();
		this.id = id;
		this.name = name;
		this.valorCompra = valorCompra;
		this.quantidadeAcao = quantidadeAcao;
		this.diaCompra = diaCompra;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acao other = (Acao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
