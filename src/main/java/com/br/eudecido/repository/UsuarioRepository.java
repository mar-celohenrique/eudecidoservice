package com.br.eudecido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eudecido.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findById(Integer id);
	
	Usuario findByCpf(String cpf);
	
	Usuario findByEmail(String email);
	
	Usuario findByEmailAndSenha(String email, String senha);

}
