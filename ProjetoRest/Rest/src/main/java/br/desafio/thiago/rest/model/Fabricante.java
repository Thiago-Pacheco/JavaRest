package br.desafio.thiago.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFabricante;

	@Column(length = 50, nullable = false)
	private String descricao;

	public Long getId() {
		return idFabricante;
	}

	public void setId(Long id) {
		this.idFabricante = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
