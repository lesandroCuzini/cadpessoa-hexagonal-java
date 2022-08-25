package br.com.teste.cadpessoa.application.request;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CadastrarPessoaRequest {
	@ApiModelProperty(value = "*Documento (CPF/CNPJ) de identificação")
	@NotBlank(message = "não deve estar em branco")
	@Length(min = 11, max = 14, message = "Identificador deve ter no minimo 11 e no máximo 14 caracteres.")
	private String identificador;
	
	@ApiModelProperty(value = "*Nome")
	@NotBlank(message = "não deve estar em branco")
	private String nome;
}
