package br.com.digitalgold.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import br.com.digitalgold.data.entity.Pessoa;
import br.com.digitalgold.data.entity.Venda;
import br.com.digitalgold.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private ProdutoService produtoService;
	
	public Venda registrarVenda(Venda venda) {
		atualizarQuantidadeProdutos(venda);
		return repository.save(venda);
	}

	private void atualizarQuantidadeProdutos(Venda venda) {
		venda.getItens().stream().forEach(item -> produtoService.atualizarEstoque(item, item.getQuantidade()));
		var valorTotalVenda = venda.getItens().stream().mapToDouble(i -> (i.getValorVenda() * i.getQuantidade())).sum();
	}
	  
	public List<Venda> retornaVendas(Pageable pageable) {
		return Streamable.of(repository.findAll(Sort.by(Sort.Direction.ASC, "id"))).toList();
	} 
	
	public List<Venda> retornaVendasPorVendedor(Pessoa vendedor) {
		return Streamable.of(repository.findAll(Sort.by(Sort.Direction.ASC, "id"))).toList();
	} 
	
	public List<Venda> retornaVendasPorCliente(Pessoa cliente) {
		return Streamable.of(repository.findAll(Sort.by(Sort.Direction.ASC, "id"))).toList();
	}
	
	
}
