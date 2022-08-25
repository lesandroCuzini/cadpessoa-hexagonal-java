package br.com.teste.cadpessoa.infrastracture.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.teste.cadpessoa.infrastracture.repository.h2.SpringDataH2PessoaRepository;

@EnableJpaRepositories(basePackageClasses = SpringDataH2PessoaRepository.class)
public class H2DBConfiguration {

}
