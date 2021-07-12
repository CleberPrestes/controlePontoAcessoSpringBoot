package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Movimentacao;


@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{

	
}
