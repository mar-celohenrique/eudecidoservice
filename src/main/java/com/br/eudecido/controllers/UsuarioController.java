package com.br.eudecido.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.eudecido.models.Usuario;
import com.br.eudecido.service.UsuarioService;

@Controller
@RestController
@RequestMapping(value = "/usuarioController")
public class UsuarioController {

	private final UsuarioService uService;

	@Autowired
	public UsuarioController(UsuarioService uService) {
		this.uService = uService;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> salvar(@RequestBody Usuario usuario) {
		return new ResponseEntity<String>(uService.salvar(usuario), HttpStatus.OK);
	}

	@RequestMapping(value = "/logar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Usuario> logar(@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(uService.logar(usuario.getEmail(), usuario.getSenha()), HttpStatus.OK);
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> atualizar(@RequestBody Usuario usuario) {
		return new ResponseEntity<String>(uService.atualizar(usuario), HttpStatus.OK);
	}

	@RequestMapping(value = "/remover", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> remover(@RequestBody Integer id) {
		uService.excluir(id);
		return new ResponseEntity<String>("excluido", HttpStatus.OK);
	}
	
	

}
