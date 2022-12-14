package br.com.digitalgold.data.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"identificador", "codigoProduto", "descricao", "quantidade", "valorUnitario", "numeroNcm"})
public class ProdutoDTO {
	
	@JsonProperty("identificador")
	private Long id;

	@JsonProperty("codigoProduto")
	private String codProduto;
	
	@JsonProperty("descricao")
	private String descricao;
	
	@JsonProperty("quantidade")
	private int quantidade;
	
	@JsonProperty("valorUnitario")
	private double valorUnitario;
	
	
	@JsonProperty("numeroNcm")
	private String numeroNcm;
	
	@JsonProperty("codigoBarra")
	private String codigoBarrasAtual;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getNumeroNcm() {
		return numeroNcm;
	}

	public void setNumeroNcm(String numeroNcm) {
		this.numeroNcm = numeroNcm;
	}

	public String getCodigoBarrasAtual() {
		return codigoBarrasAtual;
	}

	public void setCodigoBarrasAtual(String codigoBarrasAtual) {
		this.codigoBarrasAtual = codigoBarrasAtual;
	}

}
