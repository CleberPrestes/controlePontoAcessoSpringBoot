package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Empresa;
import com.example.demo.repository.EmpresaRepository;




@Service
public class EmpresaService {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	
	
	public Empresa saveEmpresa(Empresa empresa) {
		
		
		return empresaRepository.save(empresa);
	
		
		
	}



	public java.util.List<Empresa> findEmpresaAll() {
		
		return 	empresaRepository.findAll();
		
	}



	 public Optional<Empresa> getEmpresaById(Long idEmpresa) {
	        return empresaRepository.findById(idEmpresa);
	    }
	
	 
	 public Empresa updateEmpresa(Empresa empresa) {
				
			return empresaRepository.save(empresa);
		
		}
	 
	 
	 public void deleteEmpresa(Long idEmpresa) {
		 empresaRepository.deleteById(idEmpresa);
	    }
	 
	 


}
