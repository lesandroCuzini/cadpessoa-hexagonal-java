package br.com.teste.cadpessoa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Table(name = "pessoa")
@Entity
@Getter @Setter
public class Pessoa {
	
	@Id
	@Column(length = 14)
	private String identificador;
	
	@Length(max = 50, message = "Nome deve ter no máximo 50 caracteres.")
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@Setter(AccessLevel.NONE)
	@Column(length = 4)
	@Enumerated(EnumType.STRING)
	private TipoIdentificador tipoIdentificador;
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
		
		if(getIdentificador().length() == 11)
			this.tipoIdentificador = TipoIdentificador.CPF;
		else if(getIdentificador().length() == 14)
			this.tipoIdentificador = TipoIdentificador.CNPJ;
	}
}
