package com.br.eudecido.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", locale = "GMT-3")
	private Date inicio;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", locale = "GMT-3")
	private Date fim;
	@Column(nullable = false)
	private boolean conclusao;
	@ManyToOne
	private Politico politico;
	@OneToMany(fetch = FetchType.LAZY)
	@Cascade(CascadeType.DELETE)
	private List<Comentario> listaComentarios;
	@OneToMany(fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private List<Reacao> listaReacoes;

	public List<Comentario> getListaComentarios() {
		return listaComentarios;
	}

	public void setListaComentarios(List<Comentario> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}

	public List<Reacao> getListaReacoes() {
		return listaReacoes;
	}

	public void setListaReacoes(List<Reacao> listaReacoes) {
		this.listaReacoes = listaReacoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id_projeto) {
		this.id = id_projeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public boolean isConclusao() {
		return conclusao;
	}

	public void setConclusao(boolean conclusao) {
		this.conclusao = conclusao;
	}

	public Politico getPolitico() {
		return politico;
	}

	public void setPolitico(Politico politico) {
		this.politico = politico;
	}

	public Reacao getReacaoPorUsuario(Usuario usuario) {
		for (Reacao i : listaReacoes) {
			if (i.getUsuario().getId() == usuario.getId()) {
				return i;
			}
		}
		return null;
	}

	public void removerComentario(Integer id) {
		for (int i = 0; i < listaComentarios.size(); i++) {
			if (listaComentarios.get(i).getId() == id) {
				listaComentarios.remove(i);
			}
		}
	}

}
