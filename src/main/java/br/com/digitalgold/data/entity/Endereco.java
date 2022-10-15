package br.com.digitalgold.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
@Table(name="TB_ENDERECO")
//@JsonPropertyOrder({ "emp_id", "emp_name", "emp_designation", "department", "salary" })
public class Endereco implements Serializable {

	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("rua")
	@Column(name = "LOGRADOURO", nullable = false)
	private String logradouro;
	
	@JsonProperty("cep")
	@Column(name = "CEP")
	private String cep;
	
	@JsonProperty("numero")
	@Column(name = "NUMERO", nullable = false)
	private String numero;
	
	@JsonProperty("complemento")
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@JsonProperty("referencia")
	@Column(name = "REFERENCIA")
	private String referencia;
	
	@JsonProperty("bairro")
	@Column(name = "BAIRRO", nullable = false)
	private String bairro;
	
	@JsonProperty("cidade")
	@Column(name = "CIDADE", nullable = false)
	private String cidade;
	
	@JsonProperty("estado")
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@JsonProperty("pais")
	@Column(name = "PAIS")
	private String pais;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="COD_PESSOA")
	private Pessoa pessoa;

}