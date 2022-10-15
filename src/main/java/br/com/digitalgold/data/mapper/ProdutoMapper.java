package br.com.digitalgold.data.mapper;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.digitalgold.data.dto.ProdutoDTO;
import br.com.digitalgold.data.entity.Produto;

@Service
public class ProdutoMapper {

private ModelMapper modelMapper = new ModelMapper();
	
	public Produto convertToEntity(ProdutoDTO dto) {
		Produto produto = modelMapper.map(dto, Produto.class);
		/*
		produto.setCodProduto(dto.getcProd());
		produto.setDescricao(dto.getxProd());
		produto.setDataCadastro(new Date());
		produto.setQuantidade(dto.getqCom());
		produto.setValorUnitario(Double.valueOf(dto.getvUnCom()));
		produto.setCodigoBarrasAtual(dto.getCodBarras() == null ? "12345678" : dto.getCodBarras());
		*/
	    return produto;
	}
	
	public ProdutoDTO convertToDto(Produto produto) {
		ProdutoDTO dto = modelMapper.map(produto, ProdutoDTO.class);
	    
	    return dto;
	}

	public List<ProdutoDTO> convertToListDto(List<Produto> produtos) {
		List<ProdutoDTO> produtosDTO = new ArrayList<>();
		for (Produto produto : produtos) {
			produtosDTO.add(convertToDto(produto));
		}
		
		return produtosDTO;
	}
}
