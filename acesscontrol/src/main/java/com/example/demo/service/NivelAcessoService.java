package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.NivelAcesso;

import com.example.demo.repository.NivelAcessoRepository;




@Service
public class NivelAcessoService {
	
	@Autowired
	NivelAcessoRepository nivelAcessoRepository;
	
	
	
	public NivelAcesso saveNivelAcesso(NivelAcesso nivelAcesso) {
		
		
		return nivelAcessoRepository.save(nivelAcesso);
	
		
		
	}



	public java.util.List<NivelAcesso> findNivelAcessoAll() {
		
		return 	nivelAcessoRepository.findAll();
		
	}



	 public Optional<NivelAcesso> getNivelAcessoById(Long idNivelAcesso) {
	        return nivelAcessoRepository.findById(idNivelAcesso);
	    }
	
	 
	 public NivelAcesso updateNivelAcesso(NivelAcesso nivelAcesso) {
				
			return nivelAcessoRepository.save(nivelAcesso);
		
		}
	 
	 
	 public void deleteNivelAcesso(Long idNivelAcesso) {
		 nivelAcessoRepository.deleteById(idNivelAcesso);
	    }
	 
	 


}
