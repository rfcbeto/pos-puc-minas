package br.com.digitalgold.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalgold.data.entity.Venda;
import br.com.digitalgold.exceptions.PessoaException;
import br.com.digitalgold.service.VendaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendaController {
	
	@Autowired
	private VendaService service;
	
	@ApiOperation(value="Listar todas as vendas")
	@GetMapping(value="/listartodos")
	public ResponseEntity<List<?>> findAll(Pageable pageable) throws PessoaException{
		return new ResponseEntity<>(service.retornaVendas(pageable), HttpStatus.OK);
	}
	
	@ApiOperation(value="Regista/Cadastra venda realizada")
	@PostMapping
	public ResponseEntity<Venda> registrarVenda(@RequestBody Venda venda) throws PessoaException{
		
		return new ResponseEntity<Venda>(service.registrarVenda(venda), HttpStatus.OK);
	}

}
