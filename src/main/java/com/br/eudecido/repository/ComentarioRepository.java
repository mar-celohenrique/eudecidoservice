package com.br.eudecido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eudecido.models.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
	Comentario findById(Integer id);
}
