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

import com.example.demo.model.CategoriaUsuario;
import com.example.demo.service.CategoriaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/categoria")
@Api(value= "Api Controle de Acesso") //Cleber
@CrossOrigin(origins="*")
public class CategoriaUsuarioController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@PostMapping
	@ApiOperation(value="Cria uma Categoria")
	public CategoriaUsuario createJornada(@RequestBody CategoriaUsuario categoriaUsuario) {
		
		return categoriaService.saveCategoria(categoriaUsuario);
				
	}
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de Categoria")
	public List<CategoriaUsuario> getCategoriaList(){
		
		return categoriaService.findCategoriaAll();
		
	}

	 @GetMapping("/{idJornada}")
	 @ApiOperation(value="Retorna uma lista de Categoria por Id")
	    public ResponseEntity<CategoriaUsuario>  getCategoriaByID(@PathVariable("idJornada") Long idCategoria) throws Exception {
	        return  ResponseEntity.ok(categoriaService.getCategoriaById(idCategoria).orElseThrow(() -> new NoSuchElementException("Not found!")));

	    }
	 
	 @PutMapping
	 @ApiOperation(value="Atualiza uma Categoria")
		public CategoriaUsuario updateJornada(@RequestBody CategoriaUsuario categoriaUsuario) {
			
			return categoriaService.updateCategoria(categoriaUsuario);
		}
	 
		 	
		@DeleteMapping("/{idCategoria}")
		@ApiOperation(value="Deleta uma Categoria por Id")
	    public void deleteByID(@PathVariable("idCategoria") Long idCategoria) throws Exception {
	       try {
	    	   categoriaService.deleteCategoria(idCategoria);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	         
	       }
		
	    }
	 
}
