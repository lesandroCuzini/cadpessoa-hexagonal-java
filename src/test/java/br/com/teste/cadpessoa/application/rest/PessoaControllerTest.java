package br.com.teste.cadpessoa.application.rest;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.teste.cadpessoa.domain.service.PessoaService;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class PessoaControllerTest {
	
	@MockBean
    private ModelMapper modelMapper;
	
    @MockBean
    private PessoaService pessoaService;
    
    @Autowired
    PessoaController pessoaController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPostRequestToUsersAndInValidUser_thenCorrectReponse() throws Exception {
        String user = "{\"nome\": \"Pessoa teste\", \"identificador\" : \"\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificador", Is.is("não deve estar em branco")))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
}
