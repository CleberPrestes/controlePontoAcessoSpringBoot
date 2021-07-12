package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.TipoData;

import com.example.demo.repository.TipoDataRepository;




@Service
public class TipoDataService {
	
	@Autowired
	TipoDataRepository tipoDataRepository;
	
	
	
	public TipoData saveTipoData(TipoData tipoData) {
		
		
		return tipoDataRepository.save(tipoData);
	
		
		
	}



	public java.util.List<TipoData> findTipoDataAll() {
		
		return 	tipoDataRepository.findAll();
		
	}



	 public Optional<TipoData> getTipoDataById(Long idTipoData) {
	        return tipoDataRepository.findById(idTipoData);
	    }
	
	 
	 public TipoData updateTipoData(TipoData tipoData) {
				
			return tipoDataRepository.save(tipoData);
		
		}
	 
	 
	 public void deleteTipoData(Long idTipoData) {
		 tipoDataRepository.deleteById(idTipoData);
	    }
	 
	 


}
