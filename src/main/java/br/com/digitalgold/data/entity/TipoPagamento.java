package br.com.digitalgold.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="TB_TIPO_PAGAMENTO")
@Entity
public class TipoPagamento {

	@Id
	private Long id;
	
	@Column(name = "COD_TIPO_PAGAMENTO", length = 3)
	private String codTipoPagamento; 
	
	@Column(name = "TIPO_PAGAMENTO", length = 20)
	private String tipoPagamento;
	
	@Column(name="VALOR_PAGO", length = 10)
	private Double valorPago;
	
}
