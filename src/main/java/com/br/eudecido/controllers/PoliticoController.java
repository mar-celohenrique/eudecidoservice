package com.br.eudecido.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.eudecido.models.Politico;
import com.br.eudecido.models.Usuario;
import com.br.eudecido.service.PoliticoService;

@Controller
@RestController
@RequestMapping(value = "/politicoController")
public class PoliticoController {

	@Autowired
	private PoliticoService service;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> salvar(@RequestBody Politico politico) {
		return new ResponseEntity<String>(service.salvar(politico), HttpStatus.OK);
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Politico> logar(@RequestBody Integer id) {
		return new ResponseEntity<Politico>(service.buscarPorId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Politico>> listar() {
		return new ResponseEntity<List<Politico>>(service.buscarTodos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/buscarPorUsuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Politico> buscarPorUsuario(@RequestBody Usuario usuario) {
		return new ResponseEntity<Politico>(service.buscarPorUsuario(usuario), HttpStatus.OK);
	}

}
