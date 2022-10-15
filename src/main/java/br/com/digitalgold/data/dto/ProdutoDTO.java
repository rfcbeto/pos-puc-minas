package br.com.digitalgold.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"identificador", "codigo_produto", "descricao", "quantidade", "valor_unitario", "numero_ncm"})
public class ProdutoDTO {

	
	@JsonProperty("identificador")
	private Long id;

	@JsonProperty("codigo_produto")
	private String cProd;
	
	@JsonProperty("descricao")
	private String xProd;
	
	@JsonProperty("quantidade")
	private String qCom;
	
	@JsonProperty("valor_unitario")
	private String vUnCom;
	
	
	@JsonProperty("numero_ncm")
	private String ncm;
	
	@JsonProperty("codigo_barra")
	private String codBarras;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getcProd() {
		return cProd;
	}

	public void setcProd(String cProd) {
		this.cProd = cProd;
	}

	public String getxProd() {
		return xProd;
	}

	public void setxProd(String xProd) {
		this.xProd = xProd;
	}

	public String getqCom() {
		return qCom;
	}

	public void setqCom(String qCom) {
		this.qCom = qCom;
	}

	public String getvUnCom() {
		return vUnCom;
	}

	public void setvUnCom(String vUnCom) {
		this.vUnCom = vUnCom;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
}
