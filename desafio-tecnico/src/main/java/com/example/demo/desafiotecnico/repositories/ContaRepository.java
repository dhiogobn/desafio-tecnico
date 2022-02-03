package com.example.demo.desafiotecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.desafiotecnico.entities.Conta;


public interface ContaRepository extends JpaRepository<Conta, Long>{

}
