package br.com.digitalgold.data.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"identificador", "numero_nota_fiscal", "nome_fornecedor", "nome_fantasia_fornecedor", "cnpj"})
public class NotaDTO {

	
	@JsonProperty("identificador")
	private Long id;
	
	
	@JsonProperty("numero_nota_fiscal")
	private String nNF;
	
	@JsonProperty("cnpj")
	private String cnpj;
	
	@JsonProperty("nome_fornecedor")
	private String xNome;
	
	@JsonProperty("nome_fantasia_fornecedor")
	private String xFant;
	
	@JsonProperty("produtos")
	private List<ProdutoDTO> produtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getnNF() {
		return nNF;
	}

	public void setnNF(String nNF) {
		this.nNF = nNF;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getxNome() {
		return xNome;
	}

	public void setxNome(String xNome) {
		this.xNome = xNome;
	}

	public String getxFant() {
		return xFant;
	}

	public void setxFant(String xFant) {
		this.xFant = xFant;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
}
