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

import com.br.eudecido.models.Credencial;
import com.br.eudecido.service.CredencialService;

@Controller
@RestController
@RequestMapping(value = "/credencialController")
public class CredencialController {
	@Autowired
	private CredencialService service;

	@RequestMapping(value = "/salvarCredencial", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> salvarCredencial(
			@RequestBody Credencial codigo) {
		return new ResponseEntity<String>(service.salvarCredencial(codigo),
				HttpStatus.OK);
	}
}
