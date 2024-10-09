package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

}
