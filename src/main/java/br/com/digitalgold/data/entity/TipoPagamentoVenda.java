package br.com.digitalgold.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/*
@Data
@Table(name="TB_TIPO_PAGAMENTO_VENDA")
@Entity
*/
public class TipoPagamentoVenda implements Serializable{
/*
	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(position = 0)
	@SequenceGenerator(name="seq_tipo_pagamento", sequenceName = "seq_tipo_pagamento", allocationSize = 1)
	@GeneratedValue(generator = "seq_tipo_pagamento",  strategy = GenerationType.SEQUENCE)
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_TIPO_PAGAMENTO", referencedColumnName = "COD_TIPO_PAGAMENTO")
	private TipoPagamento codTipoPagamento;
	
*/	
}
