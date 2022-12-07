package br.com.digitalgold.data.enuns;

public enum TipoPagamentoEnum {

	OUTROS(0, "Outros"),
	VISTA_DINHEIRO(1, "Dinheiro"),
	VISTA_PIX(2, "Vista Pix"),
	VISTA_DEBITO(3, "Vista Debito"),
	CARTAO_CREDITO(4, "Atacadista"); 
	 
	
	int tipo;
	String descricao;
 
	private TipoPagamentoEnum(int tipo, String descricao){
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
