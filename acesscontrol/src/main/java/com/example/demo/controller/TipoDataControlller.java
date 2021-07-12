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


import com.example.demo.model.TipoData;
import com.example.demo.service.TipoDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/tipodata")
@Api(value= "Api Controle de Acesso") //Cleber
@CrossOrigin(origins="*")
public class TipoDataControlller {
	
	@Autowired
	TipoDataService tipoDataService;
	
	@PostMapping
	@ApiOperation(value="Cria um TipoData")
	public TipoData createJornada(@RequestBody TipoData tipoData) {
		
		return tipoDataService.saveTipoData(tipoData);
				
				
	}
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de tipos de data")
	public List<TipoData> getTipoDataList(){
		
		return tipoDataService.findTipoDataAll();
		
	}

	 @GetMapping("/{idTipoData}")
	 @ApiOperation(value="Retorna uma lista de tipos de data por Id")
	    public ResponseEntity<TipoData>  getCategoriaByID(@PathVariable("idTipoData") Long idTipoData) throws Exception {
	        return  ResponseEntity.ok(tipoDataService.getTipoDataById(idTipoData).orElseThrow(() -> new NoSuchElementException("Not found!")));

	    }
	 
	 @PutMapping
	 @ApiOperation(value="Atualiza um tipo de data")
		public TipoData updateTipoData(@RequestBody TipoData tipoData) {
			
			return tipoDataService.updateTipoData(tipoData);
		}
	 
		 	
		@DeleteMapping("/{idTipoData}")
		@ApiOperation(value="Deleta um tipo de data por Id")
	    public void deleteByID(@PathVariable("idTipoData") Long idTipoData) throws Exception {
	       try {
	    	   tipoDataService.deleteTipoData(idTipoData);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	         
	       }
		
	    }
	 
}
