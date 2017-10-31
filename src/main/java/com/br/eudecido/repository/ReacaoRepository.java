package com.br.eudecido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.eudecido.models.Reacao;

public interface ReacaoRepository extends JpaRepository<Reacao, Integer> {
	Reacao findById(Integer id);
}
