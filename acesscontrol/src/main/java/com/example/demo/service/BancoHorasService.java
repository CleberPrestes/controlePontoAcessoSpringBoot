package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.BancoHoras;
import com.example.demo.repository.BancoHorasRepository;




@Service
public class BancoHorasService {
	
	@Autowired
	BancoHorasRepository bancoHorasRepository;
	
	
	
	public BancoHoras saveBancoHoras(BancoHoras bancoHoras) {
		
		
		return bancoHorasRepository.save(bancoHoras);
	
		
		
	}



	public java.util.List<BancoHoras> findBancoHorasAll() {
		
		return 	bancoHorasRepository.findAll();
		
	}



	 public Optional<BancoHoras> getBancoHorasById(Long idBancoHoras) {
	        return bancoHorasRepository.findById(idBancoHoras);
	    }
	
	 
	 public BancoHoras updateBancoHoras(BancoHoras bancoHoras) {
				
			return bancoHorasRepository.save(bancoHoras);
		
		}
	 
	 
	 public void deleteBancoHoras(Long idBancoHoras) {
		 bancoHorasRepository.deleteById(idBancoHoras);
	    }
	 
	 


}
