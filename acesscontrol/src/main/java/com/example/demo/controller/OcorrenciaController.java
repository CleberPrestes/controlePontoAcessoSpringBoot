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

import com.example.demo.model.Ocorrencia;
import com.example.demo.service.OcorrenciaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/ocorrencia")
@Api(value= "Api Controle de Acesso") //Cleber
@CrossOrigin(origins="*")
public class OcorrenciaController {
	
	@Autowired
	OcorrenciaService ocorrenciaService;
	
	@PostMapping
	@ApiOperation(value="Cria uma Ocorrencia")
	public Ocorrencia createEmpresa(@RequestBody Ocorrencia ocorrencia) {
		
		return ocorrenciaService.saveOcorrencia(ocorrencia);
				
	}
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de Ocorrencias")
	public List<Ocorrencia> getOcorrenciaList(){
		
		return ocorrenciaService.findOcorrenciaAll();
		
	}

	 @GetMapping("/{idOcorrencia}")
	 @ApiOperation(value="Retorna uma lista de Ocorrencia por Id")
	    public ResponseEntity<Ocorrencia>  getEmpresaByID(@PathVariable("idOcorrencia") Long idEmpresa) throws Exception {
	        return  ResponseEntity.ok(ocorrenciaService.getOcorrenciaById(idEmpresa).orElseThrow(() -> new NoSuchElementException("Not found!")));

	    }
	 
	 @PutMapping
	 @ApiOperation(value="Atualiza uma Ocorrencia")
		public Ocorrencia updateEmpresa(@RequestBody Ocorrencia ocorrencia) {
			
			return ocorrenciaService.updateOcorrencia(ocorrencia);
		}
	 
		 	
		@DeleteMapping("/{idOcorrencia}")
		@ApiOperation(value="Deleta uma Ocorrencia por Id")
	    public void deleteByID(@PathVariable("idOcorrencia") Long idOcorrencia) throws Exception {
	       try {
	    	   ocorrenciaService.deleteOcorrencia(idOcorrencia);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	         
	       }
		
	    }
	 
}
