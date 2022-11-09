package br.com.digitalgold.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.digitalgold.data.entity.Pessoa;
import br.com.digitalgold.exceptions.PessoaException;
import br.com.digitalgold.repository.PessoaPageRepository;
import br.com.digitalgold.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private PessoaPageRepository pageRepository;
	
	public Pessoa findById(Long idPessoa) throws PessoaException{
		return repository.findById(idPessoa).orElseThrow(() -> new PessoaException("Pessoa não encontrada"));
	}

	public List<Pessoa> retornaPessoas(Pageable pageable) throws PessoaException{
		return pageRepository.findAll(pageable).getContent();
	}
	
	public Pessoa criar(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	public Pessoa atualizar(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	public void excluir(Long idPessoa) throws PessoaException{
		try {
			repository.deleteById(idPessoa);			
		} catch (Exception e) {
			throw new PessoaException("Pessoa não encontrada");
		}
	}
}
