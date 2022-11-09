package br.com.digitalgold.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonPropertyOrder({ "rua", "numero", "complemento", "cep", "bairro", "cidade", "estado", "pais", "referencia" })
@Data
@Table(name="TB_ENDERECO")
@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 2L;

	@Id
	@SequenceGenerator(name="seq_endereco", sequenceName = "seq_endereco", allocationSize = 1)
	@GeneratedValue(generator = "seq_endereco",  strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("rua")
	@Column(name = "LOGRADOURO", nullable = false)
	private String logradouro;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("cep")
	@Column(name = "CEP")
	private String cep;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("numero")
	@Column(name = "NUMERO", nullable = false)
	private String numero;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("complemento")
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("referencia")
	@Column(name = "REFERENCIA")
	private String referencia;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("bairro")
	@Column(name = "BAIRRO", nullable = false)
	private String bairro;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("cidade")
	@Column(name = "CIDADE", nullable = false)
	private String cidade;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("estado")
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("pais")
	@Column(name = "PAIS")
	private String pais;
	
	 public Endereco() {
		 
	 }
}