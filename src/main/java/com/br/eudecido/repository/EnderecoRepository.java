package com.br.eudecido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eudecido.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	Endereco findById(Integer id);

}
