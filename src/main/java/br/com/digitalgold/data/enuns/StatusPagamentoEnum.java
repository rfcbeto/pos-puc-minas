package br.com.digitalgold.data.enuns;

public enum StatusPagamentoEnum {

	PENDENTE(1, "Aguardando pagamento"),
	EM_APROVACAO(2, "Pendente de aprovação"), 
	CONCLUIDO(3, "Concluído com sucesso"), 
	FALHA(4, "Falha operação pagamento"), 
	OUTROS(5, "Outros");
	
	int tipo;
	String descricao;
 
	private StatusPagamentoEnum(int tipo, String descricao){
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
