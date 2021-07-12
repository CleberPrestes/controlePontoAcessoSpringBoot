package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.JornadaTrabalho;
import com.example.demo.repository.JornadaRepositoryy;



@Service
public class JornadaService {
	
	@Autowired
	JornadaRepositoryy jornadaRepository;
	
	
	
	public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho) {
		
		
		return jornadaRepository.save(jornadaTrabalho);
	
		
		
	}



	public java.util.List<JornadaTrabalho> findAll() {
		
		return 	jornadaRepository.findAll();
		
	}



	 public Optional<JornadaTrabalho> getById(Long idJornada) {
	        return jornadaRepository.findById(idJornada);
	    }
	
	 
	 public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho) {
				
			return jornadaRepository.save(jornadaTrabalho);
		
		}
	 
	 
	 public void deleteJornada(Long idJornada) {
	       jornadaRepository.deleteById(idJornada);
	    }
	 
	 


}
