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

import com.example.demo.model.Movimentacao;
import com.example.demo.service.MovimentacaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/movimentacao")
@Api(value= "Api Controle de Acesso") //Cleber
@CrossOrigin(origins="*")
public class MovimentacoController {
	
	@Autowired
	MovimentacaoService movimentacaoService;
	
	@PostMapping
	@ApiOperation(value="Cria uma Movimentacao")
	public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacao) {
		
		return movimentacaoService.saveMovimentacao(movimentacao);
				
	}
	
	
	@GetMapping
	@ApiOperation(value="Retorna uma lista de Movimentacao")
	public List<Movimentacao> getMovimentacaoList(){
		
		return movimentacaoService.findMovimentacaoAll();
		
	}

	 @GetMapping("/{idMovimentacao}")
	 @ApiOperation(value="Retorna uma lista de Movimentacao por Id")
	    public ResponseEntity<Movimentacao>  getEmpresaByID(@PathVariable("idMovimentacao") Long idMovimentacao) throws Exception {
	        return  ResponseEntity.ok(movimentacaoService.getMovimentacaoById(idMovimentacao).orElseThrow(() -> new NoSuchElementException("Not found!")));

	    }
	 
	 @PutMapping
	 @ApiOperation(value="Atualiza uma Movimentacao")
		public Movimentacao updateEmpresa(@RequestBody Movimentacao movimentacao) {
			
			return movimentacaoService.updateMovimentacao(movimentacao);
		}
	 
		 	
		@DeleteMapping("/{idMovimentacao}")
		@ApiOperation(value="Deleta uma Movimentacao por Id")
	    public void deleteByID(@PathVariable("idMovimentacao") Long idMovimentacao) throws Exception {
	       try {
	    	   movimentacaoService.deleteMovimentacao(idMovimentacao);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	         
	       }
		
	    }
	 
}
