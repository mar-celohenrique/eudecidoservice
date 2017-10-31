package com.br.eudecido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eudecido.models.Reacao;

import java.util.Optional;

public interface ReacaoRepository extends JpaRepository<Reacao, Integer> {
	Optional<Reacao> findById(Integer id);
}
