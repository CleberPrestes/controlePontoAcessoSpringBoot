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

import com.example.demo.model.Calendario;
import com.example.demo.service.CalendarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/calendario")
@Api(value= "Api Controle de Acesso") //Cleber
@CrossOrigin(origins="*")
public class CalendarioController {
	
	@Autowired
	CalendarioService calendarioService;
	
	@PostMapping
	@ApiOperation(value="Cria um Calendario")
	public Calendario createJornada(@RequestBody Calendario calendario) {
		
		return calendarioService.saveCalendario(calendario);
				
				
	}
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de Calendario")
	public List<Calendario> getCalendarioList(){
		
		return calendarioService.findCalendarioAll();
			
		
	}

	 @GetMapping("/{idCalendario}")
	 @ApiOperation(value="Retorna uma lista de Calendarios por Id")
	    public ResponseEntity<Calendario>  getCategoriaByID(@PathVariable("idCalendario") Long idCalendario) throws Exception {
	        return  ResponseEntity.ok(calendarioService.getCalendarioById(idCalendario).orElseThrow(() -> new NoSuchElementException("Not found!")));

	    }
	 
	 @PutMapping
	 @ApiOperation(value="Atualiza um Calendario")
		public Calendario updateCalendario(@RequestBody Calendario calendario) {
			
			return calendarioService.updateCalendario(calendario);
		}
	 
		 	
		@DeleteMapping("/{idCalendario}")
		@ApiOperation(value="Deleta um calendario por Id")
	    public void deleteByID(@PathVariable("idCalendario") Long idCalendario) throws Exception {
	       try {
	    	   calendarioService.deleteCalendario(idCalendario);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	         
	       }
		
	    }
	 
}
