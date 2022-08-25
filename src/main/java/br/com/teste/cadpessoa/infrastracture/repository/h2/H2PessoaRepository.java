package br.com.teste.cadpessoa.infrastracture.repository.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.com.teste.cadpessoa.domain.Pessoa;
import br.com.teste.cadpessoa.domain.repository.PessoaRepository;

@Component
@Primary
public class H2PessoaRepository implements PessoaRepository {

	private final SpringDataH2PessoaRepository pessoaRepository;
	
	@Autowired
	public H2PessoaRepository(final SpringDataH2PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	@Override
	public void gravar(final Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
}
