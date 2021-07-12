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

import com.example.demo.model.BancoHoras;
import com.example.demo.service.BancoHorasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/bancohoras")
@Api(value= "Api Controle de Acesso") //Cleber
@CrossOrigin(origins="*")
public class BancoHorasController {
	
	@Autowired
	BancoHorasService bancoHorasService;
	
	@PostMapping
	@ApiOperation(value="Cria um Banco de Horas")
	public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras) {
		
		return bancoHorasService.saveBancoHoras(bancoHoras);
				
				
	}
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de Banco de Horas")
	public List<BancoHoras> getBancoHorasList(){
		
		return bancoHorasService.findBancoHorasAll();
			
		
	}

	 @GetMapping("/{idBancoHoras}")
	 @ApiOperation(value="Retorna uma lista de Banco de Hora por Id")
	    public ResponseEntity<BancoHoras>  getBancoHorasByID(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
	        return  ResponseEntity.ok(bancoHorasService.getBancoHorasById(idBancoHoras).orElseThrow(() -> new NoSuchElementException("Not found!")));

	    }
	 
	 @PutMapping
	 @ApiOperation(value="Atualiza um Banco de Horas")
		public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras) {
			
			return bancoHorasService.updateBancoHoras(bancoHoras);
		}
	 
		 	
		@DeleteMapping("/{idBancoHoras}")
		@ApiOperation(value="Deleta um Banco de Horas por Id")
	    public void deleteBancoHorasByID(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
	       try {
	    	   bancoHorasService.deleteBancoHoras(idBancoHoras);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	         
	       }
		
	    }
	 
}
