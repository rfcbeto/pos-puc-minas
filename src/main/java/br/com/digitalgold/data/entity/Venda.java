package br.com.digitalgold.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.digitalgold.data.enuns.SituacaoVendaEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Table(name="TB_VENDA")
@Entity
@JsonPropertyOrder({ "id", "tipo", "status", "cliente", "vendedor", "itens", "notaSaida", "dataPedido", "dataVenda", "dataEntrega", "dataTroca" })
@JsonInclude(Include.NON_NULL)
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(position = 0)
	@SequenceGenerator(name="SEQ_VENDA", sequenceName = "SEQ_VENDA", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_VENDA",  strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_VENDEDOR")
	private Pessoa vendedor;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Pessoa cliente;
	
	
	@ManyToMany
	@JoinTable(name="TB_ITEM_VENDA", joinColumns = {
			@JoinColumn(name="ID_VENDA")}, inverseJoinColumns = {@JoinColumn(name="ID_PRODUTO")})
	private List<Produto> itens;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "STATUS")
	private SituacaoVendaEnum status;
	
	//private Nota notaSaida;
	
	@OneToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name="ID_PAGAMENTO")
	private Pagamento situacaoPagamento;
	
	@Column(name="DATA_PEDIDO")
	private Date dataPedido;
	
	@Column(name="DATA_VENDA")
	private Date dataVenda;
	
	@Column(name="DATA_ENTREGA")
	private Date dataEntrega;
	
	@Column(name="DATA_TROCA")
	private Date dataTroca;
}
