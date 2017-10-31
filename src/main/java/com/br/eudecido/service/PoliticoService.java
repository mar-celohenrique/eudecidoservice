package com.br.eudecido.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eudecido.models.Credencial;
import com.br.eudecido.models.Politico;
import com.br.eudecido.models.Usuario;
import com.br.eudecido.repository.CredencialRepository;
import com.br.eudecido.repository.PoliticoRepository;

@Service
public class PoliticoService {

	@Autowired
	private PoliticoRepository repository;
	@Autowired
	private CredencialRepository crRepository;

	public String salvar(Politico politico) {
		Credencial c = crRepository.findByCodigo(politico.getCredencial().getCodigo());
		System.out.println(politico.getId());
		if (c != null) {
			politico.setCredencial(c);

			Date inicio = new Date(System.currentTimeMillis());
			Date fim;

			Calendar calendario = Calendar.getInstance();
			calendario.setTime(inicio);
			calendario.set(Calendar.MONTH, 1);
			calendario.set(Calendar.DAY_OF_MONTH, 1);

			politico.setInicio_mandato(inicio);

			calendario.set(Calendar.MONTH, 12);
			calendario.set(Calendar.DAY_OF_MONTH, 31);
			calendario.add(Calendar.YEAR, +4);
			fim = calendario.getTime();

			politico.setFim_mandato(fim);
			repository.save(politico);
			return "sucesso";
		}
		return "erro";

	}

	public Politico buscarPorId(Integer id) {
		Politico politico = repository.findById(id);
		if (politico != null) {
			return politico;
		}
		return null;
	}
	
	public Politico buscarPorUsuario(Usuario usuario){
		Politico politico = repository.findByUsuario(usuario);
		if(politico != null){
			return politico;
		}
		return null;
	}

	public List<Politico> buscarTodos() {
		return repository.findAll();
	}
}
