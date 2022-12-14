package br.com.digitalgold.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "TB_NOTA")
public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "numero_nota_fiscal")
	private String nNF;
	
	@Column(name = "nu_cnpj")
	private String cnpj;
	
	@Column(name = "nome")
	private String xNome;
	
	@Column(name = "nome_fantasia")
	private String xFant;
	
	@OneToMany(targetEntity = Produto.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id", referencedColumnName = "id")
	private List<Produto> produtos = new ArrayList<>();

}
