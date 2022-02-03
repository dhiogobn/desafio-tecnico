package com.example.demo.desafiotecnico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.desafiotecnico.entities.Conta;
import com.example.demo.desafiotecnico.entities.Transacao;
import com.example.demo.desafiotecnico.services.ContaService;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<Conta>> getContas(){
		List<Conta> contas = service.listarContas();
		return ResponseEntity.ok(contas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> getConta(@PathVariable long id){
		Conta conta =service.getContaById(id);
		return ResponseEntity.ok(conta);
	}
	
	@PostMapping
	public ResponseEntity<Conta> criarConta(@RequestBody Conta conta){
		service.criarConta(conta);
		return ResponseEntity.ok(conta);
	}
	
	@PutMapping(value = "/depositar/{id}/{valor}")
	public ResponseEntity<Conta> criarConta(@PathVariable long id, @PathVariable double valor){
		
		return ResponseEntity.ok(service.depositar(id, valor));
	}
	
	@GetMapping("/saldo/{id}")
	public ResponseEntity<String> consultaSaldo(@PathVariable long id){
		return ResponseEntity.ok("Saldo da conta é: "+service.getContaById(id).getSaldo());
	}
	
	@PutMapping(value = "/sacar/{id}/{valor}")
	public ResponseEntity<Conta> saqueConta(@PathVariable long id, @PathVariable double valor){
		
		return ResponseEntity.ok(service.sacar(id, valor));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Conta> bloquearConta(@PathVariable long id){
		Conta conta = service.getContaById(id);
		service.bloquearConta(id);
		return ResponseEntity.ok(conta);
	}
	
	@PutMapping("/transferir/{id1}/{id2}/{valor}")
	public ResponseEntity<Transacao> realizarTransferencia(@PathVariable long id1, @PathVariable long id2, @PathVariable double valor){
		return ResponseEntity.ok(service.Transferir(id1, id2, valor));
	}
	
}
