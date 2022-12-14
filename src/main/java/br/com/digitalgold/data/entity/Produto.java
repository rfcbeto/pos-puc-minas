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

import org.hibernate.annotations.Comment;

import br.com.digitalgold.data.enuns.TipoProdutoEnum;
import lombok.Data;


@Data
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
	
		
}