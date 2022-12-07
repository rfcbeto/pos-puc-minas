package br.com.digitalgold.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

import br.com.digitalgold.data.enuns.TipoProdutoEnum;



@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CODIGO_PRODUTO")
	private String codProduto;
	
	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "QUANTIDADE")
	private int quantidade;

	@Column(name = "CODIGO_BARRAS_ANTIGO")
	private String codigoBarrasAntigo;

	@Column(name = "CODIGO_BARRAS_ATUAL", nullable = false, unique = true)
	private String codigoBarrasAtual;

	@Column(name = "QR_CODE")
	private String qrCode;
	
	@Column(name = "DATA_CADASTRO")
	private Date dataCadastro;
	
	@Column(name = "DATA_FIM")
	private Date dataFim;
	
	@Column(name = "DATA_ALTERACAO_VALOR_VENDA")
	private Date dataAlteracaoValorVenda;

	@Column(name = "VALOR_CUSTO")
	private Double valorUnitario;
	
	@Column(name = "VALOR_VENDA")
	private Double valorVenda;
	
	@Enumerated(EnumType.ORDINAL)
	@Comment("0 - Anel, 1 - Alianca, 2 - Colar, 3 - Pulseira, 4 - Brinco, 5 - Pingente, 6 - Outros")
	@Column(name = "TIPO_PRODUTO", columnDefinition="INTEGER")
	private TipoProdutoEnum tipoProduto;
	
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
}