package com.br.eudecido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eudecido.models.Credencial;
import com.br.eudecido.repository.CredencialRepository;

@Service
public class CredencialService {
	@Autowired
	private CredencialRepository repository;
		
	public String salvarCredencial(Credencial credencial){
		repository.save(credencial);
		return "sucesso";
	}
}
