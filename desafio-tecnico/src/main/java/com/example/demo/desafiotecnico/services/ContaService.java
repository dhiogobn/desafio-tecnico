package com.example.demo.desafiotecnico.services;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.desafiotecnico.entities.Conta;
import com.example.demo.desafiotecnico.entities.Transacao;
import com.example.demo.desafiotecnico.repositories.ContaRepository;
import com.example.demo.desafiotecnico.repositories.TransacaoRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repository;
	
	@Autowired
	private TransacaoRepository tRepository;
	
	public Conta getContaById(long id) {
		return repository.findById(id).get();
	}
	
	
	public void criarConta(Conta conta) {
		repository.save(conta);
	}
	
	public List<Conta> listarContas(){
		List<Conta> contas = repository.findAll();
		return contas;
	}
	
	public Conta depositar(long id, double valor) {
		Conta conta = repository.findById(id).get();
		conta.setSaldo(valor+conta.getSaldo());
		repository.save(conta);
		return conta;
	}
	
	public Conta sacar(long id, double valor) {
		Conta conta = repository.findById(id).get();
		conta.setSaldo(conta.getSaldo()-valor);
		repository.save(conta);
		return conta;
	}


	public void bloquearConta(long id) {
		repository.deleteById(id);
	}
	
	
	public Transacao Transferir(long id1, long id2, double valor) {
		Conta conta = repository.findById(id1).get();
		Conta conta2 = repository.findById(id2).get();
		conta.setSaldo(conta.getSaldo()-valor);
		conta2.setSaldo(conta2.getSaldo()+valor);
		repository.save(conta);
		repository.save(conta2);
		Transacao transacao = new Transacao((int) id1, valor, LocalDateTime.now());
		tRepository.save(transacao);
		return transacao;
	}

	
}
