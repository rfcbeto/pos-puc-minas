package br.com.digitalgold.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"codigo_produto", "descricao", "valor_venda"})
public class ProdutoQrCodeDTO {

	@JsonProperty("codigo_produto")
	private String codigo;
	
	@JsonProperty("descricao")
	private String descricao;
	
	@JsonProperty("valor_venda")
	private String valor;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
