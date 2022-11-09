package br.com.digitalgold.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalgold.data.entity.Pessoa;
import br.com.digitalgold.exceptions.PessoaException;
import br.com.digitalgold.service.PessoaService;
import br.com.digitalgold.utils.DataUtil;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@ApiOperation(value="Recuperar cliente por id")
	@GetMapping(value="/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable("id")String id) throws PessoaException {
		if (id != null) {
			return new ResponseEntity<>(service.findById(Long.valueOf(id)), HttpStatus.OK);
		}
		throw new PessoaException(DataUtil.ddMMyyyhhmmss24H(), "Erro", "Valor inválido!");
	}
	
	@ApiOperation(value="Listar todos os clientes")
	@GetMapping(value="/listartodos")
	public ResponseEntity<List<Pessoa>> findAll(Pageable pageable) throws PessoaException{
		return new ResponseEntity<>(service.retornaPessoas(pageable), HttpStatus.OK);
	}
	
	@ApiOperation(value="Adicionar um novo cliente/vendedor")
	@PostMapping
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa){
		return new ResponseEntity<Pessoa>(service.criar(pessoa), HttpStatus.OK);
	}
	
	@ApiOperation(value="Atualizar dados da pessoa")
	@PutMapping
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		return new ResponseEntity<Pessoa>(service.atualizar(pessoa), HttpStatus.OK);
	}
	

	@ApiOperation(value="Excluir pessoa")
	@DeleteMapping(value="/{id}")
	public void excluir(@PathVariable("id")String idPessoa) throws PessoaException{
		if (idPessoa != null) {
			service.excluir(Long.valueOf(idPessoa));				
		} else {
			throw new PessoaException(DataUtil.ddMMyyyhhmmss24H(), "Erro", "Pessoa inválida");
		}
	}
	
}
