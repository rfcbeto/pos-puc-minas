package br.com.digitalgold.data.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.digitalgold.data.enuns.TipoPessoaEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@Table(name="TB_PESSOA")
@Entity
@JsonPropertyOrder({ "id", "nome", "genero", "dataNascimento", "cpf", "telefone", "tipo", "tipoPessoa", "status", "enderecos" })
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(position = 0)
	@SequenceGenerator(name="seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1)
	@GeneratedValue(generator = "seq_pessoa",  strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@JsonProperty("nome")
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@JsonProperty("sexo")
	@Column(name = "GENERO", length = 1)
	private String genero;

	@JsonProperty("cpf")
	@Column(name = "CPF", length = 11)
	private String cpf;

	
	@JsonProperty("telefone")
	@Column(name = "TELEFONE", length = 11)
	private String telefone;
	
	@JsonProperty("status")
	@JsonInclude(Include.NON_NULL)
	@Column(name = "STATUS", length = 20)
	private String status;
	
	@JsonProperty("dataNascimento")
	@Column(name = "DATA_NASCIMENTO", length = 10)
	private String dataNascimento;
	
	@Enumerated(EnumType.ORDINAL)
	@Comment("0 - Outros, 1 - Cliente Varejista, 2 - Cliente Atacadista, 3 - Vendedor, 4 - Gerente")
	@Column(name = "tipo", columnDefinition="INTEGER")
	private TipoPessoaEnum tipoPessoa;
	
	@OneToMany(targetEntity = Endereco.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Set<Endereco> enderecos = new HashSet<>();

	
}