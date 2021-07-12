package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.demo.model.CategoriaUsuario;

import com.example.demo.repository.CategoriaRepository;




@Service
public class CategoriaService {
	

	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	
	public CategoriaUsuario saveCategoria(CategoriaUsuario categoriaUsuario) {
		
		
		return categoriaRepository.save(categoriaUsuario);
	
		
		
	}



	public java.util.List<CategoriaUsuario> findCategoriaAll() {
		
		return 	categoriaRepository.findAll();
		
	}



	 public Optional<CategoriaUsuario> getCategoriaById(Long idCategoria) {
	        return categoriaRepository.findById(idCategoria);
	    }
	
	 
	 public CategoriaUsuario updateCategoria(CategoriaUsuario categoriaUsuario) {
				
			return categoriaRepository.save(categoriaUsuario);
		
		}
	 
	 
	 public void deleteCategoria(Long idCategoria) {
		 categoriaRepository.deleteById(idCategoria);
	    }
	 
	 

}
