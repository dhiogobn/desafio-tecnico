package com.example.demo.desafiotecnico.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor
public class Conta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long idpessoa;
	private double saldo;
	private double limiteSaldoDiario;
	private boolean flagAtivo;
	private int tipoConta;
	private String dataCriação;
	public Conta(long idpessoa, double saldo, double limiteSaldoDiario, boolean flagAtivo, int tipoConta,
			String dataCriação) {
		super();
		this.idpessoa = idpessoa;
		this.saldo = saldo;
		this.limiteSaldoDiario = limiteSaldoDiario;
		this.flagAtivo = flagAtivo;
		this.tipoConta = tipoConta;
		this.dataCriação = dataCriação;
	}
	public Conta() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdpessoa() {
		return idpessoa;
	}
	public void setIdpessoa(long idpessoa) {
		this.idpessoa = idpessoa;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimiteSaldoDiario() {
		return limiteSaldoDiario;
	}
	public void setLimiteSaldoDiario(double limiteSaldoDiario) {
		this.limiteSaldoDiario = limiteSaldoDiario;
	}
	public boolean isFlagAtivo() {
		return flagAtivo;
	}
	public void setFlagAtivo(boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}
	public int getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}
	public String getDataCriação() {
		return dataCriação;
	}
	public void setDataCriação(String dataCriação) {
		this.dataCriação = dataCriação;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return id == other.id;
	}

	
	
	
	
	

}
