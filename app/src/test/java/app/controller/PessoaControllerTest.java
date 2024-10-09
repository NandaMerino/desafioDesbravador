package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.Pessoa;
import app.repository.PessoaRepository;
import app.service.PessoaService;


@SpringBootTest
public class PessoaControllerTest {
	@Autowired
	PessoaController pessoaController;

	@Mock
    private PessoaService pessoaService;
	
	@MockBean
	PessoaRepository pessoaRepository;
	
	@BeforeEach
	void setup() {
		List<Pessoa>listaPessoa = new ArrayList<>();
		listaPessoa.add(new Pessoa(1, "Fernanda", LocalDate.of(1989,04,03), "633.832.960-40", false, true));
		listaPessoa.add(new Pessoa(2, "Mariana", LocalDate.of(1985, 1, 15), "845.255.590-39", true, false));
		listaPessoa.add(null);
		
		long id = 0;
		
		Pessoa pessoa = new Pessoa();
		
        when(pessoaService.save(any(Pessoa.class))).thenReturn("Pessoa salva com sucesso");
		
	}	
	
	@Test
    @DisplayName("Teste de sucesso ao salvar uma pessoa")
    void testSave() {
        Pessoa pessoa = new Pessoa(1, "Fernanda", LocalDate.of(1989, 4, 3), "633.832.960-40", false, true);

        ResponseEntity<String> response = pessoaController.save(pessoa);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
	
	@Test
    @DisplayName("Teste de erro ao salvar uma pessoa")
    void testSaveError() {
		Pessoa pessoa = new Pessoa();
		ResponseEntity<String>response = pessoaController.save(null);
		assertTrue(response.getStatusCode() == HttpStatus.BAD_REQUEST);
    }

}
