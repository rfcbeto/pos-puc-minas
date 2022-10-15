package br.com.digitalgold.data.enuns;

public enum TipoProdutoEnum {

	
	ANEL(1, "Anel"), ALIANCA(2, "Aliança"), COLAR(3, "Colar"), PULSEIRA(4, "Pulseira"), BRINCO(5, "Brinco"), PINGENTE(6, "Pingente"), OUTROS(0, "Outros");
	
	int tipo;
	String descricao;
 
	private TipoProdutoEnum(int tipo, String descricao){
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
