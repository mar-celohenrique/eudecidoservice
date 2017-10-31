package com.br.eudecido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eudecido.models.Credencial;

public interface CredencialRepository extends JpaRepository<Credencial, Integer>{
	
	Credencial findByCodigo(String codigo);


}
