package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Ocorrencia;

import com.example.demo.repository.OcorrenciaRepository;




@Service
public class OcorrenciaService {
	
	@Autowired
	OcorrenciaRepository ocorrenciaRepository;
	
	
	
	public Ocorrencia saveOcorrencia(Ocorrencia ocorrencia) {
		
		
		return ocorrenciaRepository.save(ocorrencia);
	
		
		
	}



	public java.util.List<Ocorrencia> findOcorrenciaAll() {
		
		return 	ocorrenciaRepository.findAll();
		
	}



	 public Optional<Ocorrencia> getOcorrenciaById(Long idOcorrencia) {
	        return ocorrenciaRepository.findById(idOcorrencia);
	    }
	
	 
	 public Ocorrencia updateOcorrencia(Ocorrencia ocorrencia) {
				
			return ocorrenciaRepository.save(ocorrencia);
		
		}
	 
	 
	 public void deleteOcorrencia(Long idOcorrencia) {
		 ocorrenciaRepository.deleteById(idOcorrencia);
	    }
	 
	 


}
