package br.com.digitalgold.data.mapper;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalgold.data.dto.NotaDTO;
import br.com.digitalgold.data.dto.ProdutoDTO;
import br.com.digitalgold.data.entity.Nota;
import br.com.digitalgold.data.entity.Produto;

@Service
public class NotaMapper {

	 private ModelMapper modelMapper = new ModelMapper();
	 
	 @Autowired
	 private ProdutoMapper produtoMapper;
	
	public Nota convertToEntity(NotaDTO dto) {
	    Nota nota = modelMapper.map(dto, Nota.class);
	   
	    if(dto.getProdutos() != null) {
	    	nota.setProdutos(dto.getProdutos().stream().map(p -> produtoMapper.convertToEntity(p)).collect(Collectors.toList()));
	    }
	    
	    return nota;
	}
	
	private Produto montarEntidadeProduto(ProdutoDTO dto, Nota nota) {
		Produto entity = produtoMapper.convertToEntity(dto);
		//entity.setNota(nota); 
		entity.setCodigoBarrasAtual(dto.getCodigoBarrasAtual());
		return entity;
	}

	public NotaDTO convertToDto(Nota nota) {
		NotaDTO dto = modelMapper.map(nota, NotaDTO.class);
	    
	    return dto;
	}
}
