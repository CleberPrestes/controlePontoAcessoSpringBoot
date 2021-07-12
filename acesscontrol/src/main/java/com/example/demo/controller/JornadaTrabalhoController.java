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

import com.example.demo.model.JornadaTrabalho;
import com.example.demo.service.JornadaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/jornada")
@Api(value= "Api Controle de Acesso") //Cleber
@CrossOrigin(origins="*")
public class JornadaTrabalhoController {
	
	@Autowired
	JornadaService jornadaService;
	
	@PostMapping
	@ApiOperation(value="Cria uma jornada")
	public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		
		return jornadaService.saveJornada(jornadaTrabalho);
	}
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de Jornadas")
	public List<JornadaTrabalho> getJornadaList(){
		
		return jornadaService.findAll();
		
	}

	 @GetMapping("/{idJornada}")
	 @ApiOperation(value="Retorna uma lista de Jornadas por Id")
	    public ResponseEntity<JornadaTrabalho>  getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
	        return  ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new NoSuchElementException("Not found!")));

	    }
	 
	 @PutMapping
	 @ApiOperation(value="Atualiza uma Jornadas")
		public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
			
			return jornadaService.updateJornada(jornadaTrabalho);
		}
	 
		 	
		@DeleteMapping("/{idJornada}")
		@ApiOperation(value="Deleta uma Jornada por Id")
	    public void deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
	       try {
	           jornadaService.deleteJornada(idJornada);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	         
	       }
		
	    }
	 
}
