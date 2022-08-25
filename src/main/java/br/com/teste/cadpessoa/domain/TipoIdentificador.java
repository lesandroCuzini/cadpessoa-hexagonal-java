package br.com.teste.cadpessoa.domain;

public enum TipoIdentificador {
	CPF("CPF"), CNPJ("CNPJ");
	
	private String tipoIdentificador;
	
	TipoIdentificador(String tipoIdentificador) {
		this.tipoIdentificador = tipoIdentificador;
	}
	
	public String getTipoIdentificador() {
		return tipoIdentificador;
	}
}
