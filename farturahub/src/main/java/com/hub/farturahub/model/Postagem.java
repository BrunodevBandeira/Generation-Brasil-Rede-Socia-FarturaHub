package com.hub.farturahub.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 3, max = 100)
	private String titulo;
	
	@NotNull
	@Size(min = 1, max = 1000)
	private String descricao;
	
	@NotNull
	@Size(min = 2, max = 20)
	private String regiao;
	
	@NotNull
	private Boolean ajudado;
	
	@NotNull
	@Size(min = 2, max = 50)
	private String nomeAjudante;
	
	@NotNull
	@Size(min = 10, max = 100)
	private String contato;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date data = new java.sql.Date(System.currentTimeMillis());
	
	//relacionamento
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	

	//encapsulamento
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Boolean getAjudado() {
		return ajudado;
	}

	public void setAjudado(Boolean ajudado) {
		this.ajudado = ajudado;
	}

	public String getNomeAjudante() {
		return nomeAjudante;
	}

	public void setNomeAjudante(String nomeAjudante) {
		this.nomeAjudante = nomeAjudante;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}
