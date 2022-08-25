package br.com.teste.cadpessoa.application.rest;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import br.com.teste.cadpessoa.application.request.CadastrarPessoaRequest;
import br.com.teste.cadpessoa.domain.Pessoa;
import br.com.teste.cadpessoa.domain.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	private final ModelMapper modelMapper;
	private final PessoaService pessoaService;
	
	@Autowired
	public PessoaController(PessoaService pessoaService, ModelMapper modelMapper) {
		this.pessoaService = pessoaService;
		this.modelMapper = modelMapper;
	}

	@ApiResponses(value = {
		    @ApiResponse(code = 201, message = "Pessoa cadastrada")
		})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	void cadastrarPessoa(@Valid @RequestBody final CadastrarPessoaRequest cadastrarPessoaRequest) {
		Pessoa pessoa = modelMapper.map(cadastrarPessoaRequest, Pessoa.class);
		pessoaService.gravarPessoa(pessoa);
	}
	
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
