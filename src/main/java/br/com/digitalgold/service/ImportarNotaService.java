package br.com.digitalgold.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.digitalgold.data.dto.NotaDTO;
import br.com.digitalgold.data.dto.ProdutoDTO;
import br.com.digitalgold.data.entity.Nota;
import br.com.digitalgold.data.entity.Produto;
import br.com.digitalgold.data.mapper.NotaMapper;
import br.com.digitalgold.repository.NotaRepository;


@Service
public class ImportarNotaService {
	
	@Autowired
	private NotaRepository repository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private NotaMapper mapper;

	public List<NotaDTO> importar(String folder) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		List<NotaDTO> notasDto = new ArrayList<>();
		NotaDTO notaDTO = null;
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			List<String> pathNotas = getPathNotas(folder);
			for(String nota : pathNotas) {
				List<ProdutoDTO> produtos = new ArrayList<>();
				notaDTO = new NotaDTO();
				
				Document doc = db.parse(new File(nota));
				doc.getDocumentElement().normalize();
				NodeList notaFiscal = doc.getElementsByTagName("nNF");
				notaDTO.setnNF(notaFiscal.item(0).getTextContent());
				
				NodeList cnpj = doc.getElementsByTagName("CNPJ");
				notaDTO.setCnpj(cnpj.item(0).getTextContent());
				
				NodeList nome = doc.getElementsByTagName("xNome");
				notaDTO.setxNome(nome.item(0).getTextContent());
				
				NodeList nomeFantasia = doc.getElementsByTagName("xFant");
				notaDTO.setxFant(nomeFantasia.item(0).getTextContent());
				
				NodeList produto = doc.getElementsByTagName("prod");
				
				montarProduto(produtos, produto);
				notaDTO.setProdutos(produtos);
				notasDto.add(notaDTO);
			};
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return notaDTO != null ? montarSalvarNota(notaDTO) : null;
	}

	private List<NotaDTO> montarSalvarNota(NotaDTO notaDTO) {
		// Nota nota = DozerConverter.parseObject(notaDTO, Nota.class);
		Nota notaEntity = new Nota();
		BeanUtils.copyProperties(notaDTO, notaEntity); //copyProperties(notaDTO, Nota.class);
		
		List<Produto> produtosEntity = new ArrayList<>(); 

	     for (ProdutoDTO produtoDto: notaDTO.getProdutos() ) {
	        Produto produtoEntity = new Produto();
	        BeanUtils.copyProperties(produtoDto, produtoEntity);
	        produtosEntity.add(produtoEntity);
	     }
	     
		notaEntity.setProdutos(produtosEntity);
/*
		Produto prod = new Produto();
		prod.setCodigoBarrasAntigo(notaDTO.getProdutos().get(0).getCodBarras());
		prod.setCodigoBarrasAtual("123456789123456789");
		prod.setDataAlteracaoValorVenda(new Date());
		prod.setDataCadastro(new Date());
		prod.setDescricao(notaDTO.getProdutos().get(0).getxProd());
		prod.setQuantidade(notaDTO.getProdutos().get(0).getqCom());
		prod.setValorUnitario(notaDTO.getProdutos().get(0).getvUnCom());
		prod.setValorVenda(notaDTO.getProdutos().get(0).getvUnCom()*5);
		produtoService.gravar(prod);

		produtos.forEach(p -> produtoService.gravar(p));
*/		
		//nota.setProdutos(produtos);
		List<Nota> listaNota = new ArrayList<>();
		
		listaNota.add(repository.save(notaEntity));
		return null;
	}

	private void montarProduto(List<ProdutoDTO> produtos, NodeList produto) {
		for(int i = 0; i < produto.getLength(); i++) {
			ProdutoDTO dto = new ProdutoDTO();
			Node node = produto.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				dto.setCodigoBarrasAtual(element.getElementsByTagName("cProd").item(0).getTextContent());
				dto.setDescricao(element.getElementsByTagName("xProd").item(0).getTextContent());
				dto.setQuantidade(Double.valueOf(element.getElementsByTagName("qCom").item(0).getTextContent()).intValue());
				dto.setValorUnitario(Double.valueOf(element.getElementsByTagName("vUnCom").item(0).getTextContent()));
				dto.setNumeroNcm(element.getElementsByTagName("NCM").item(0).getTextContent());
			}
			produtos.add(dto);
		}
	}
	
	private List<String> getPathNotas(String localFolder) {
		List<String> pathNotas = new ArrayList<>();
		File folder = new File(localFolder);
				
		for (File arquivo : folder.listFiles()) {
			int index = arquivo.getName().lastIndexOf('.');
			  if (arquivo.isFile() && "xml".equalsIgnoreCase(arquivo.getName().substring(index + 1))) {
				  pathNotas.add(arquivo.getAbsolutePath());
			  }
		}
		
		return pathNotas;
	}
}
