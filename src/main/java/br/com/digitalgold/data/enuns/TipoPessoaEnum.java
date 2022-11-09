package br.com.digitalgold.data.enuns;

public enum TipoPessoaEnum {

	OUTROS(0, "Outros"),
	CLIENTE_VAREJO(1, "Varejo"), 
	CLIENTE_ATACADO(2, "Atacadista"), 
	VENDEDOR(3, "Vendedor"), 
	GERENTE(4, "Gerente"); 
	
	int tipo;
	String descricao;
 
	private TipoPessoaEnum(int tipo, String descricao){
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
