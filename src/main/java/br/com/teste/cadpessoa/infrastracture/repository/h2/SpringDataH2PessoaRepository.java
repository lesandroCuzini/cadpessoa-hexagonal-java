package br.com.teste.cadpessoa.infrastracture.repository.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.cadpessoa.domain.Pessoa;

@Repository	
public interface SpringDataH2PessoaRepository extends JpaRepository<Pessoa, String> {

}
