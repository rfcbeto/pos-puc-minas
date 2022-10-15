package br.com.digitalgold.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalgold.data.entity.Pessoa;

@Repository
public interface PessoaPageRepository extends PagingAndSortingRepository<Pessoa, Long> {

}
