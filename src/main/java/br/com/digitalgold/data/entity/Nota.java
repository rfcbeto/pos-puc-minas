package br.com.digitalgold.data.entity;

import java.io.Serializable;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@OneToMany(targetEntity = Produto.class, orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "nota_id", referencedColumnName = "id")
	private List<Produto> produtos;
	 

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


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	@Override
	public String toString() {
		return "Nota [id=" + id + ", nNF=" + nNF + ", cnpj=" + cnpj + ", xNome=" + xNome + ", xFant=" + xFant + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nNF == null) ? 0 : nNF.hashCode());
		result = prime * result + ((xFant == null) ? 0 : xFant.hashCode());
		result = prime * result + ((xNome == null) ? 0 : xNome.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nNF == null) {
			if (other.nNF != null)
				return false;
		} else if (!nNF.equals(other.nNF))
			return false;
		if (xFant == null) {
			if (other.xFant != null)
				return false;
		} else if (!xFant.equals(other.xFant))
			return false;
		if (xNome == null) {
			if (other.xNome != null)
				return false;
		} else if (!xNome.equals(other.xNome))
			return false;
		return true;
	}
}
