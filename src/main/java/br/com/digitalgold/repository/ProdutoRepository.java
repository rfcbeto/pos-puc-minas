package br.com.digitalgold.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.digitalgold.data.entity.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {

	@Query("SELECT p FROM Produto p WHERE (p.codigoBarrasAtual = :codigoProduto OR  p.codigoBarrasAntigo = :codigoProduto) ")
	Produto findByCodigo(@Param("codigoProduto") String codigoProduto);
	
}
