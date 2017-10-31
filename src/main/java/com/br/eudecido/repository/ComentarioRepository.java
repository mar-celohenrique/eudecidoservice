package com.br.eudecido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eudecido.models.Comentario;

import java.util.Optional;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
	Optional<Comentario> findById(Integer id);
}
