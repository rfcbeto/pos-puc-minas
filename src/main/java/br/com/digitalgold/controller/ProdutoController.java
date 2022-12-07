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

import br.com.digitalgold.data.dto.ProdutoDTO;
import br.com.digitalgold.data.entity.Produto;
import br.com.digitalgold.service.ProdutoService;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value = "/api/v1/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@ApiOperation(value="Listar todos os produtos")
	@GetMapping(value="/listartodos")
	public ResponseEntity<List<Produto>> findAll(Pageable pageable) throws Exception{
		return new ResponseEntity<>(service.retornaProdutos(pageable), HttpStatus.OK);
	}
	
	@ApiOperation(value="Recuperar produto por id do produto")
	@GetMapping(value="/id/{id}")
	public ResponseEntity<Produto> findById(@PathVariable("id")String idProduto) throws Exception {
		Produto produto = service.findById(Long.valueOf(idProduto));
		if(produto != null) {
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		} else {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND).body(produto);
		}
	}
	
	@ApiOperation(value="Recuperar produto por codigo")
	@GetMapping(value="/codigo/{codigo}")
	public ResponseEntity<Produto> findByCodigo(@PathVariable("codigo")String codigoProduto) {
		Produto produto = service.findByCodigo(codigoProduto);
		if(produto != null) {
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		} else {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND).body(produto);
		}
	}
	
	@ApiOperation(value="Cadastrar novo produto")
	@PostMapping
	public ResponseEntity<Produto> criar(@RequestBody Produto produto) throws Exception{
		return new ResponseEntity<Produto>(service.gravar(produto), HttpStatus.OK);
	}
}
