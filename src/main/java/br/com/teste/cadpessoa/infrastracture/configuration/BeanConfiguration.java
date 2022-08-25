package br.com.teste.cadpessoa.infrastracture.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.teste.cadpessoa.CadpessoaApplication;
import br.com.teste.cadpessoa.domain.repository.PessoaRepository;
import br.com.teste.cadpessoa.domain.service.DomainPessoaService;
import br.com.teste.cadpessoa.domain.service.PessoaService;

@Configuration
@ComponentScan(basePackageClasses = CadpessoaApplication.class)
public class BeanConfiguration {

	@Bean
	PessoaService pessoaService(final PessoaRepository pessoaRepository) {
		return new DomainPessoaService(pessoaRepository);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
}
