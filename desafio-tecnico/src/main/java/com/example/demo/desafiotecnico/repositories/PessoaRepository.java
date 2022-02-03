package com.example.demo.desafiotecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.desafiotecnico.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
