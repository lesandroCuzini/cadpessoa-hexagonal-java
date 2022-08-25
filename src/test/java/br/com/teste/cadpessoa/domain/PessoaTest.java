package br.com.teste.cadpessoa.domain;

import org.junit.Assert;
import org.junit.Test;

public class PessoaTest {
	@Test
    public void whenTipoIdentificadorIsCPF() {
		Pessoa pessoaTeste = new Pessoa();
		pessoaTeste.setNome("Usuario Teste 1");
		pessoaTeste.setIdentificador("11122233344");
		
		Assert.assertEquals(TipoIdentificador.CPF, pessoaTeste.getTipoIdentificador());
	}
	
	@Test
    public void whenTipoIdentificadorIsCNPJ() {
		Pessoa pessoaTeste = new Pessoa();
		pessoaTeste.setNome("Usuario Teste 1");
		pessoaTeste.setIdentificador("00111222000199");
		
		Assert.assertEquals(TipoIdentificador.CNPJ, pessoaTeste.getTipoIdentificador());
	}
}
