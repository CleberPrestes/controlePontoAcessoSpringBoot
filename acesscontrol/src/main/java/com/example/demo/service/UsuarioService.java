package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;

import com.example.demo.repository.UsuarioRepository;




@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	
	public Usuario saveUsuario(Usuario usuario) {
		
		
		return usuarioRepository.save(usuario);
	
		
		
	}



	public java.util.List<Usuario> findUsuarioAll() {
		
		return 	usuarioRepository.findAll();
		
	}



	 public Optional<Usuario> getUsuarioById(Long idUsuario) {
	        return usuarioRepository.findById(idUsuario);
	    }
	
	 
	 public Usuario updateUsuario(Usuario usuario) {
				
			return usuarioRepository.save(usuario);
		
		}
	 
	 
	 public void deleteUsuario(Long idUsuario) {
		 usuarioRepository.deleteById(idUsuario);
	    }
	 
	 


}
