package br.com.digitalgold.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import br.com.digitalgold.data.entity.Produto;
import br.com.digitalgold.data.mapper.ProdutoMapper;
import br.com.digitalgold.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private ProdutoMapper mapper;
	
	public Produto gravar(Produto produto) {
		return repository.save(produto);
	}
	
	public List<Produto> retornaProdutos(Pageable pageable) throws Exception{
		return Streamable.of(repository.findAll(Sort.by(Sort.Direction.ASC, "id"))).toList();
	}

	public Produto findByCodigo(String codigoProduto) {
		return repository.findByCodigo(codigoProduto);
	}
	
	public Produto findById(Long idProduto) throws Exception{
		return repository.findById(idProduto).orElseThrow(() -> new Exception("Produto não encontrado não encontrada"));
	}

	public Produto atualizarEstoque(Produto produto, int quantidade){
		return atualizarEstoqueProduto(produto, quantidade);
	}
	
	private Produto atualizarEstoqueProduto(Produto produto, int quantidade) {
		Produto produtoAtualizado = repository.findById(produto.getId()).get();
		validarQuantidadeDisponivel(quantidade, produtoAtualizado);
		
		return repository.save(produtoAtualizado);
	}

	private void validarQuantidadeDisponivel(int quantidade, Produto produtoAtualizado) {
		int quantidadeDisponivel = produtoAtualizado.getQuantidade();
		int qtdCompra = quantidade <= quantidadeDisponivel ? quantidade : quantidadeDisponivel;
		produtoAtualizado.setQuantidade(produtoAtualizado.getQuantidade() - qtdCompra);
	}
}
