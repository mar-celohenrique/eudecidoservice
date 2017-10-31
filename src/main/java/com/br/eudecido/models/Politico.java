package com.br.eudecido.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Politico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", locale = "GMT-3")
	private Date inicio_mandato;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", locale = "GMT-3")
	private Date fim_mandato;

	@OneToOne(optional = true)
	@Cascade(CascadeType.ALL)
	private Credencial credencial;
	@Column(nullable = false)
	private String cargo;
	@OneToOne
	private Usuario usuario;

	public Date getInicio_mandato() {
		return inicio_mandato;
	}

	public void setInicio_mandato(Date inicio_mandado) {
		this.inicio_mandato = inicio_mandado;
	}

	public Date getFim_mandato() {
		return fim_mandato;
	}

	public void setFim_mandato(Date fim_mandato) {
		this.fim_mandato = fim_mandato;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
