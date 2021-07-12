package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Movimentacao;
import com.example.demo.repository.MovimentacaoRepository;




@Service
public class MovimentacaoService {
	
	@Autowired
	MovimentacaoRepository movimentacaoRepository;
	
	
	
	public Movimentacao saveMovimentacao(Movimentacao movimentacao) {
		
		
		return movimentacaoRepository.save(movimentacao);
	
		
		
	}



	public java.util.List<Movimentacao> findMovimentacaoAll() {
		
		return 	movimentacaoRepository.findAll();
		
	}



	 public Optional<Movimentacao> getMovimentacaoById(Long idMovimentacao) {
	        return movimentacaoRepository.findById(idMovimentacao);
	    }
	
	 
	 public Movimentacao updateMovimentacao(Movimentacao movimentacao) {
				
			return movimentacaoRepository.save(movimentacao);
		
		}
	 
	 
	 public void deleteMovimentacao(Long idMovimentacao) {
		 movimentacaoRepository.deleteById(idMovimentacao);
	    }
	 
	 


}
