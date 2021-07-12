package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Calendario;
import com.example.demo.repository.CalendarioRepository;




@Service
public class CalendarioService {
	

	
	@Autowired
	CalendarioRepository calendarioRepository;
	
	
	
	public Calendario saveCalendario(Calendario calendario) {
		
		
		return calendarioRepository.save(calendario);
	
		
		
	}



	public java.util.List<Calendario> findCalendarioAll() {
		
		return 	calendarioRepository.findAll();
		
	}



	 public Optional<Calendario> getCalendarioById(Long idCalendario) {
	        return calendarioRepository.findById(idCalendario);
	    }
	
	 
	 public Calendario updateCalendario(Calendario calendario) {
				
			return calendarioRepository.save(calendario);
		
		}
	 
	 
	 public void deleteCalendario(Long idCalendario) {
		 calendarioRepository.deleteById(idCalendario);
	    }
	
}
