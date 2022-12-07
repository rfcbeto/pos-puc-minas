package br.com.digitalgold.data.enuns;

public enum SituacaoVendaEnum {

	
	PEDIDO_REALIZADO(1, "Pedido realizado"), 
	AGUARDANDO_PAGAMENTO(2, "Aguardando pagamento"),  
	EM_SEPARACAO(3, "Preparando"), 
	AGUARDANDO_RETIRADA(4, "Aguardando retirada"), 
	REALIZADA_COM_SUCESSO(5, "Realizada com sucesso"), 
	CANCELADA(6, "Cancelada"), 
	OUTROS(0, "Outros");
	
	int tipo;
	String descricao;
 
	private SituacaoVendaEnum(int tipo, String descricao){
		this.tipo = tipo;
		this.descricao = descricao;
	}
 
	public int getTipo(){
		return tipo;
	}
	
	public String getDescricao(){
		return descricao;
	}
}
