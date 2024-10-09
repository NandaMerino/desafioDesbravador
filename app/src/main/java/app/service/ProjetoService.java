package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Projeto;
import app.repository.ProjetoRepository;

@Service
public class ProjetoService {
	@Autowired
	private ProjetoRepository projetoRepository;

	public String save(Projeto projeto) {
		this.projetoRepository.save(projeto);
		return "Projeto " + projeto.getNome() + " cadastrado com sucesso!";
	}

	public String update(long id, Projeto projeto) {
		projeto.setId(id);
		this.projetoRepository.save(projeto);
		return projeto.getNome()+ " atualizado com sucesso";
	}

	public List<Projeto> listAll(){
		return this.projetoRepository.findAll();
	}

	public Projeto findById(long idProjeto) {

		Projeto projeto = this.projetoRepository.findById(idProjeto).get();
		return projeto;

	}

	public String delete(long idProjeto) {
		this.projetoRepository.deleteById(idProjeto);
		return "Cadastro deletado com sucesso!";

	}

}
