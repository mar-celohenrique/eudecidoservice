package com.br.eudecido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eudecido.models.Endereco;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	Optional<Endereco> findById(Integer id);

}
