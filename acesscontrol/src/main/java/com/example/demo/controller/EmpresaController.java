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

import com.example.demo.model.Empresa;
import com.example.demo.service.EmpresaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/empresa")
@Api(value= "Api Controle de Acesso") //Cleber
@CrossOrigin(origins="*")
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaService;
	
	@PostMapping
	@ApiOperation(value="Cria uma Empresa")
	public Empresa createEmpresa(@RequestBody Empresa empresa) {
		
		return empresaService.saveEmpresa(empresa);
				
	}
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de Empresa")
	public List<Empresa> getEmpresaList(){
		
		return empresaService.findEmpresaAll();
		
	}

	 @GetMapping("/{idEmpresa}")
	 @ApiOperation(value="Retorna uma lista de Empresa por Id")
	    public ResponseEntity<Empresa>  getEmpresaByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
	        return  ResponseEntity.ok(empresaService.getEmpresaById(idEmpresa).orElseThrow(() -> new NoSuchElementException("Not found!")));

	    }
	 
	 @PutMapping
	 @ApiOperation(value="Atualiza uma Empresa")
		public Empresa updateEmpresa(@RequestBody Empresa empresa) {
			
			return empresaService.updateEmpresa(empresa);
		}
	 
		 	
		@DeleteMapping("/{idEmpresa}")
		@ApiOperation(value="Deleta uma Empresa por Id")
	    public void deleteByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
	       try {
	    	   empresaService.deleteEmpresa(idEmpresa);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	         
	       }
		
	    }
	 
}
