package br.com.teste.cadpessoa.domain.service;

import br.com.teste.cadpessoa.domain.Pessoa;
import br.com.teste.cadpessoa.domain.repository.PessoaRepository;

public class DomainPessoaService implements PessoaService {

	private final PessoaRepository pessoaRepository;
	
	public DomainPessoaService(final PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	@Override
	public void gravarPessoa(Pessoa pessoa) {
		pessoaRepository.gravar(pessoa);
	}
}
