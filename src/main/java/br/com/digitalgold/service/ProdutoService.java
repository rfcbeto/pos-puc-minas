package br.com.digitalgold.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalgold.data.dto.ProdutoDTO;
import br.com.digitalgold.data.entity.Produto;
import br.com.digitalgold.data.mapper.ProdutoMapper;
import br.com.digitalgold.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoMapper mapper;
	
	public Produto gravar(Produto produto) {
		Produto p = produtoRepository.save(produto);
		return p;
	}
	
	public List<ProdutoDTO> findAll() throws Exception{
		List<ProdutoDTO> produtosDTO = mapper.convertToListDto((List<Produto>)produtoRepository.findAll());
		return produtosDTO;
	}

	public Produto findByCodigo(String codigoProduto) {
		return produtoRepository.findByCodigo(codigoProduto);
	}
}
