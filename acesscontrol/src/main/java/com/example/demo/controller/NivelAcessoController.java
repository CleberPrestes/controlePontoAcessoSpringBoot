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

import com.example.demo.model.NivelAcesso;
import com.example.demo.service.NivelAcessoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/nivelacesso")
@Api(value= "Api Controle de Acesso") //Cleber
@CrossOrigin(origins="*")
public class NivelAcessoController {
	
	@Autowired
	NivelAcessoService nivelAcessoService;
	
	@PostMapping
	@ApiOperation(value="Cria um Nivel Acesso")
	public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
		
		return nivelAcessoService.saveNivelAcesso(nivelAcesso);
				
	}
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de Nivel Acesso")
	public List<NivelAcesso> getEmpresaList(){
		
		return nivelAcessoService.findNivelAcessoAll();
		
	}

	 @GetMapping("/{idEmpresa}")
	 @ApiOperation(value="Retorna uma lista de um nivel de acesso por Id")
	    public ResponseEntity<NivelAcesso>  getEmpresaByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
	        return  ResponseEntity.ok(nivelAcessoService.getNivelAcessoById(idEmpresa).orElseThrow(() -> new NoSuchElementException("Not found!")));

	    }
	 
	 @PutMapping
	 @ApiOperation(value="Atualiza um nivel de acesso")
		public NivelAcesso updateEmpresa(@RequestBody NivelAcesso empresa) {
			
			return nivelAcessoService.updateNivelAcesso(empresa);
		}
	 
		 	
		@DeleteMapping("/{idEmpresa}")
		@ApiOperation(value="Deleta um nivel de acesso por Id")
	    public void deleteByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
	       try {
	    	   nivelAcessoService.deleteNivelAcesso(idEmpresa);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	         
	       }
		
	    }
	 
}
