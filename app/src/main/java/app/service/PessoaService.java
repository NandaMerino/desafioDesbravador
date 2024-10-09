package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Pessoa;
import app.repository.PessoaRepository;


@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;

	public String save(Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
		return pessoa.getNome() + " cadastrado com sucesso!";
	}

	public String update(long id, Pessoa pessoa) {
		pessoa.setId(id);
		this.pessoaRepository.save(pessoa);
		return pessoa.getNome()+ " atualizado com sucesso";
	}

	public List<Pessoa> listAll(){
		return this.pessoaRepository.findAll();
	}

	public Pessoa findById(long idPessoa) {
		Pessoa pessoa = this.pessoaRepository.findById(idPessoa).get();
		return pessoa;
	}

	public String delete(long idProjeto) {
		this.pessoaRepository.deleteById(idProjeto);
		return "Cadastro deletado com sucesso!";

	}


}
