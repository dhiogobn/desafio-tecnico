package com.example.demo.desafiotecnico.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long idTransacao;
	private long idConta;
	private double valor;
	private LocalDateTime dataTransacao;
	
	public Transacao(int idConta, double valor, LocalDateTime dataTransacao) {
		super();
		this.idConta = idConta;
		this.valor = valor;
		this.dataTransacao = dataTransacao;
	}
	public Transacao() {
		super();
	}
	public long getIdTransacao() {
		return idTransacao;
	}
	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}
	public long getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDateTime getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(LocalDateTime dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	
	
	
	
	
	

}
