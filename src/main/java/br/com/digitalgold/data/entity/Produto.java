package br.com.digitalgold.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.digitalgold.data.enuns.TipoProdutoEnum;



@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "codigo_produto")
	private String codProduto;
	
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "quantidade")
	private String quantidade;

	@Column(name = "codigo_barras_antigo")
	private String codigoBarrasAntigo;

	@Column(name = "codigo_barras_atual", nullable = false)
	private String codigoBarrasAtual;

	@Column(name = "qr_code")
	private String qrCode;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@Column(name = "data_fim")
	private Date dataFim;
	
	@Column(name = "data_alteracao_valor_venda")
	private Date dataAlteracaoValorVenda;

	@Column(name = "valor_custo")
	private Double valorUnitario;
	
	@Column(name = "valor_venda")
	private Double valorVenda;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_produto", columnDefinition="INTEGER COMMENT '0 - Anel, 1 - Alianca, 2 - Colar, 3 - Pulseira, 4 - Brinco, 5 - Pingente, 6 - Outros'")
	private TipoProdutoEnum tipoProduto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_nota")
	//@Transient
	private Nota nota;

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

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getCodigoBarrasAntigo() {
		return codigoBarrasAntigo;
	}

	public void setCodigoBarrasAntigo(String codigoBarrasAntigo) {
		this.codigoBarrasAntigo = codigoBarrasAntigo;
	}

	public String getCodigoBarrasAtual() {
		return codigoBarrasAtual;
	}

	public void setCodigoBarrasAtual(String codigoBarrasAtual) {
		this.codigoBarrasAtual = codigoBarrasAtual;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataAlteracaoValorVenda() {
		return dataAlteracaoValorVenda;
	}

	public void setDataAlteracaoValorVenda(Date dataAlteracaoValorVenda) {
		this.dataAlteracaoValorVenda = dataAlteracaoValorVenda;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public TipoProdutoEnum getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProdutoEnum tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}		
}