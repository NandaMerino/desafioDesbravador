package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Pessoa;
import app.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin("*")
public class PessoaController {
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Pessoa pessoa) {
		
		try {
			
			String mensagem = this.pessoaService.save(pessoa);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Pessoa pessoa, @PathVariable int id) {
		
		try {
			
			String mensagem = this.pessoaService.update(id, pessoa);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Ocorreu um erro ao tentar alterar: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Pessoa>> listAll (){
		
		try {
			
			List<Pessoa> lista = this.pessoaService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/findById/{idPessoa}")
	public ResponseEntity<Pessoa> findById(@PathVariable long idPessoa){
		
		try {
			
			Pessoa pessoa = this.pessoaService.findById(idPessoa);
			return new ResponseEntity<>(pessoa, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/delete/{idPessoa}")
	public ResponseEntity<String> delete(@PathVariable long idPessoa){
		
		try {
			
			String mensagem = this.pessoaService.delete(idPessoa);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu um erro ao tentar deletar: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

}
