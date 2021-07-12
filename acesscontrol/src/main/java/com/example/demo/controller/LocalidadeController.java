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

import com.example.demo.model.Localidade;
import com.example.demo.service.LocalidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController

@RequestMapping("/localidade")
@Api(value= "Api Controle de Acesso") //Cleber
@CrossOrigin(origins="*")
public class LocalidadeController {

	
	@Autowired
	LocalidadeService localidadeService;
	
	@PostMapping
	@ApiOperation(value="Cria uma Localidade")
	public Localidade createLocalidade(@RequestBody Localidade localidade) {
		
		return localidadeService.saveLocalidade(localidade);
	}
	

	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de Localidades")
	public List<Localidade> getJornadaList(){
		
		
		return localidadeService.findLocalidadeAll();
		
	}

	 @GetMapping("/{idLocalidade}")
	 @ApiOperation(value="Retorna uma lista de Localidades por Id")
	 
	    public ResponseEntity<Localidade>  getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
	        return  ResponseEntity.ok(localidadeService.getLocalidadeById(idJornada).orElseThrow(() -> new NoSuchElementException("Not found!")));

	    }
	 
	 @PutMapping
	 @ApiOperation(value="Atualiza uma Localidade")
		public Localidade updateJornada(@RequestBody Localidade jornadaTrabalho) {
			
			return localidadeService.updateLocalidade(jornadaTrabalho);
		}
	 
		 	
		@DeleteMapping("/{idLocalidade}")
		@ApiOperation(value="Deleta uma Localidade por Id")
		
	    public void deleteByID(@PathVariable("idLocalidade") Long idJornada) throws Exception {
	       try {
	           localidadeService.deleteLocalidade(idJornada);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	         
	       }
		
	    }
	 
}
