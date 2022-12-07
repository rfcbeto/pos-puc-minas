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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.digitalgold.data.enuns.StatusPagamentoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Table(name="TB_PAGAMENTO")
@Entity
public class Pagamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(position = 0)
	@SequenceGenerator(name="seq_pagamento_venda", sequenceName = "seq_pagamento_venda", allocationSize = 1)
	@GeneratedValue(generator = "seq_pagamento_venda",  strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToMany(targetEntity = Pagamento.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "COD_TIPO_PAGAMENTO", referencedColumnName = "id")
	private List<TipoPagamento> tipoPagamento;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status_pagamento")
	private StatusPagamentoEnum situacao;
	
	@Column(name = "cod_agamento")
	private String codPagamento;
	
	@Column(name = "data_pagamento")
	private Date dataPagamento;
	
	@OneToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name="id_venda")
	private Venda venda;
	
	@Column(name="VALOR_TOTAL_PAGO")
	private Double valorTotalPago;
	
	/* CRIAR FUNÇÃO PARA DETERMINAR QTO FOI PAGO EM CADA TIPO DE PAGAMENTO UTILIZADO NO PAGAMENTO DA VENDA. 
	 * EXEMPLO.
	 * VALOR TOTAL COMPRA 150,00
	 * 
	 * DINHEIRO = 18,00
	 * PIX = 89,00
	 * CREDITO = 43,00
	 * 
	 * */
	
	
}
