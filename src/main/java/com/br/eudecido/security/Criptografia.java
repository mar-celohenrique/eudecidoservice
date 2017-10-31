package com.br.eudecido.security;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class Criptografia {
	
	public String criptografar(String senha){
		return new Base64().encodeToString(senha.getBytes());
	}
	
}
