package br.com.digitalgold.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.digitalgold.data.entity.Venda;

public interface VendaRepository extends PagingAndSortingRepository<Venda, Long>   {

}
