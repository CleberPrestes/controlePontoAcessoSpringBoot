package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/usuario")
@Api(value= "Api Controle de Acesso") //Cleber
@CrossOrigin(origins="*")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	@ApiOperation(value="Cria um Usuario")
	public Usuario createJornada(@RequestBody Usuario usuario) {
		
		return usuarioService.saveUsuario(usuario);
				
				
	}
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de Usuarios")
	public List<Usuario> getUsuarioList(){
		
		return usuarioService.findUsuarioAll();
		
	}

	 @GetMapping("/{idUsuario}")
	 @ApiOperation(value="Retorna uma lista de Usuario por Id")
	    public ResponseEntity<Usuario>  getCategoriaByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
	        return  ResponseEntity.ok(usuarioService.getUsuarioById(idUsuario).orElseThrow(() -> new NoSuchElementException("Not found!")));

	    }
	 
	 @PutMapping
	 @ApiOperation(value="Atualiza um Usuario")
		public Usuario updateUsuario(@RequestBody Usuario usuario) {
			
			return usuarioService.updateUsuario(usuario);
		}
	 
		 	
		@DeleteMapping("/{idUsuario}")
		@ApiOperation(value="Deleta um usuario por Id")
	    public void deleteByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
	       try {
	    	   usuarioService.deleteUsuario(idUsuario);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	         
	       }
		
	    }
	 
}
