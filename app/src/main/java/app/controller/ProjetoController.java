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

import app.entity.Projeto;
import app.service.ProjetoService;

@RestController
@RequestMapping("/api/projeto")
@CrossOrigin("*")
public class ProjetoController {
	@Autowired
	private ProjetoService projetoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Projeto projeto) {
		
		try {
			
			String mensagem = this.projetoService.save(projeto);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Ocorreu um erro ao tentar salvar: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Projeto projeto, @PathVariable int id) {
		
		try {
			
			String mensagem = this.projetoService.update(id, projeto);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Ocorreu um erro ao tentar alterar: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Projeto>> listAll (){
		
		try {
			
			List<Projeto> lista = this.projetoService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/findById/{idProjeto}")
	public ResponseEntity<Projeto> findById(@PathVariable long idProjeto){
		
		try {
			
			Projeto projeto = this.projetoService.findById(idProjeto);
			return new ResponseEntity<>(projeto, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/delete/{idProjeto}")
	public ResponseEntity<String> delete(@PathVariable long idProjeto){
		
		try {
			
			String mensagem = this.projetoService.delete(idProjeto);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu um erro ao tentar deletar: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

}
