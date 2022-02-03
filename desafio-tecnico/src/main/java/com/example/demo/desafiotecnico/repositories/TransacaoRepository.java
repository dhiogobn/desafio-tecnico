package com.example.demo.desafiotecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.desafiotecnico.entities.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
