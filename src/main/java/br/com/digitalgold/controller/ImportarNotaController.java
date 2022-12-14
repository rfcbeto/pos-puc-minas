package br.com.digitalgold.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalgold.data.dto.NotaDTO;
import br.com.digitalgold.data.dto.ProdutoDTO;
import br.com.digitalgold.service.ImportarNotaService;

@RestController
@RequestMapping(value = "/api/v1/notas")
public class ImportarNotaController {
	
	@Autowired
	private ImportarNotaService service;
	
	@GetMapping(value = "/importar/{folder}")
	public ResponseEntity<List<NotaDTO>> importarNotaFiscal(@PathVariable("folder") String folder) {
		folder = "C:/Desenvolvimento";
		List<NotaDTO> notas = new ArrayList<NotaDTO>();
		notas = service.importar(folder);
		
		return new ResponseEntity<List<NotaDTO>>(notas, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/criar")
	public ResponseEntity<NotaDTO> criarProduto(@RequestBody List<ProdutoDTO> produtosDTO){
		NotaDTO nota = new NotaDTO();
		nota.setnNF("000001");
		nota.setxNome("Nota produtos legado");
		nota.setxFant("Produtos legado");
		nota.setCnpj("00000000000123");
		nota.setId(0L);
		nota.setProdutos(produtosDTO);
		
		return new ResponseEntity<NotaDTO>(nota, HttpStatus.OK);
	} 
}
