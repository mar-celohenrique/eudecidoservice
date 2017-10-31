package com.br.eudecido.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eudecido.models.Comentario;
import com.br.eudecido.models.Politico;
import com.br.eudecido.models.Projeto;
import com.br.eudecido.models.Reacao;
import com.br.eudecido.repository.ComentarioRepository;
import com.br.eudecido.repository.ProjetoRepository;
import com.br.eudecido.repository.ReacaoRepository;

@Service
public class ProjetoService {

    private String sucesso = "sucesso";
    private String erro = "erro";

    @Autowired
    private ProjetoRepository repositoryProjeto;

    @Autowired
    private ReacaoRepository repositoryReacao;

    @Autowired
    private ComentarioRepository repositoryComentario;

    // Parte Projeto

    public String salvar(Projeto projeto) {
        repositoryProjeto.save(projeto);

        return sucesso;
    }

    public String excluir(Integer id) {
        Optional<Projeto> projeto = repositoryProjeto.findById(id);
        if (projeto != null) {
            repositoryProjeto.delete(projeto.get());
            return sucesso;
        }
        return erro;
    }

    public List<Projeto> listar() {
        return repositoryProjeto.findAll();
    }

    public List<Projeto> listarPorUsuario(Politico politico) {
        return repositoryProjeto.findByPolitico(politico);
    }

    public List<Projeto> listarPorNome(String nome) {
        return repositoryProjeto.findByNomeContainingIgnoreCase(nome);
    }

    public Projeto buscarPorId(Integer id) {
        Optional<Projeto> projeto = repositoryProjeto.findById(id);
        if (projeto != null) {
            return projeto.get();
        }
        return null;
    }

    public Projeto buscarPorIdNotLazy(Integer id) {
        Projeto projeto = repositoryProjeto.findByIdNotLazy(id);
        if (projeto != null) {
            return projeto;
        }
        return null;
    }

    // Parte Reacao

    public String salvarReacao(Projeto projeto) {
        Reacao reacao = projeto.getListaReacoes().get(0);
        Projeto p = this.buscarPorId(projeto.getId());
        Reacao r = p.getReacaoPorUsuario(reacao.getUsuario());

        if (r == null) {
            repositoryReacao.save(reacao);
            p.getListaReacoes().add(reacao);
            repositoryProjeto.save(p);
        } else {
            r.setGostei(reacao.isGostei());
            repositoryReacao.save(r);
        }
        return sucesso;
    }

    public String excluirReacao(Integer id) {
        Optional<Reacao> reacao = repositoryReacao.findById(id);
        if (reacao != null) {
            repositoryReacao.delete(reacao.get());
            return sucesso;
        }
        return erro;
    }

    // Parte Comentario

    public String salvarComentario(Projeto projeto) {
        Comentario comentario = projeto.getListaComentarios().get(0);
        Projeto p = this.buscarPorId(projeto.getId());
        p.getListaComentarios().add(comentario);
        repositoryComentario.save(comentario);
        repositoryProjeto.save(p);
        return sucesso;
    }

    public String excluirComentario(Projeto projeto) {
        Optional<Comentario> comentario = repositoryComentario.findById(projeto.getListaComentarios().get(0).getId());
        Projeto p = this.buscarPorId(projeto.getId());
        p.removerComentario(comentario.get().getId());
        repositoryProjeto.save(p);
        repositoryComentario.delete(comentario.get());
        return sucesso;
    }
}
