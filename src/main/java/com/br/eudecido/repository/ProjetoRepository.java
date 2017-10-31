package com.br.eudecido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.eudecido.models.Politico;
import com.br.eudecido.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{
	
	Projeto findById(Integer id);
	
	List<Projeto> findByNomeContainingIgnoreCase(String nome);
	
	List<Projeto> findByPolitico(Politico politico);
	
	@Query("SELECT p FROM Projeto p WHERE p.id = (:id)")
	Projeto findByIdNotLazy(@Param("id") Integer id);
}
