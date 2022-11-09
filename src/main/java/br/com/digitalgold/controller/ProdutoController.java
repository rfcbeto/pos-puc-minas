package br.com.digitalgold.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalgold.data.dto.ProdutoDTO;
import br.com.digitalgold.data.entity.Produto;
import br.com.digitalgold.service.ProdutoService;



@RestController
@RequestMapping(value = "/api/v1/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping(value="/listartodos")
	public ResponseEntity<List<ProdutoDTO>> findAll(Pageable pageable) throws Exception{
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{codigo}")
	public ResponseEntity<Produto> findByCodigo(@PathVariable("codigo")String codigoProduto) throws Exception{
		Produto produto = service.findByCodigo(codigoProduto);
		if(produto != null) {
			return new ResponseEntity<>(produto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}
	}
}
