package br.com.digitalgold.data.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;


@Entity
@Data
@Table(name="TB_PESSOA")
//@JsonPropertyOrder({ "emp_id", "emp_name", "emp_designation", "department", "salary" })
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("nome")
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@JsonProperty("sexo")
	@Column(name = "GENERO", length = 1)
	private String genero;
	
	@JsonProperty("telefone")
	@Column(name = "TELEFONE", length = 11)
	private String telefone;
	
	@JsonProperty("tipo")
	@Column(name = "TIPO", length = 20)
	private String tipo;
	
	@JsonProperty("status")
	@Column(name = "STATUS", length = 20)
	private String status;
	
	@JsonProperty("data_nascimento")
	@Column(name = "DATA_NASCIMENTO", length = 10)
	private String dataNascimento;
	
	/*
	@OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
	private List<Contato> contatos = new ArrayList<>(); 
	*/
	
	@JsonProperty("endereco")
	@OneToMany(
		targetEntity = Endereco.class,
		mappedBy = "pessoa",
		orphanRemoval = true,
		fetch = FetchType.LAZY,
        cascade = CascadeType.PERSIST
    )
	private Set<Endereco> enderecos;
	
	
	
}