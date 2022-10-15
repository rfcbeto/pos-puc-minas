package br.com.digitalgold.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalgold.data.entity.Pessoa;
import br.com.digitalgold.exceptions.PessoaException;
import br.com.digitalgold.service.PessoaService;
import br.com.digitalgold.utils.DataUtil;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable("id")String id) throws PessoaException {
		if (id != null) {
			return new ResponseEntity<>(service.findById(Long.valueOf(id)), HttpStatus.OK);
		}
		throw new PessoaException(DataUtil.ddMMyyyhhmmss24H(), "Erro", "Valor inválido!");
	}
	
	@GetMapping(value="/listartodos")
	public ResponseEntity<List<Pessoa>> findAll(Pageable pageable) throws PessoaException{
		return new ResponseEntity<>(service.retornaPessoas(pageable), HttpStatus.OK);
	}
	
	
	@PostMapping(value="/criar")
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa){
		return new ResponseEntity<Pessoa>(service.criar(pessoa), HttpStatus.OK);
	}
}
