package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Localidade;
import com.example.demo.repository.LocalidadeRepository;



@Service
public class LocalidadeService {
	
	@Autowired
	LocalidadeRepository localidadeRepository;
	
	
	
	public Localidade saveLocalidade(Localidade localidade) {
		
		
		return localidadeRepository.save(localidade);
				
	
		
		
	}



	public java.util.List<Localidade> findLocalidadeAll() {
		
		return 	localidadeRepository.findAll();
				
		
	}



	 public Optional<Localidade> getLocalidadeById(Long idJornada) {
	        return localidadeRepository.findById(idJornada);
	    }
	
	 
	 public Localidade updateLocalidade(Localidade localidade) {
				
			return localidadeRepository.save(localidade);
		
		}
	 
	 
	 public void deleteLocalidade(Long idLocalidade) {
	       localidadeRepository.deleteById(idLocalidade);
	    }
	 
	 


}
