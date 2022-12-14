package br.com.digitalgold.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalgold.data.entity.Nota;

@Repository
public interface NotaRepository extends PagingAndSortingRepository<Nota, Long> {

}
