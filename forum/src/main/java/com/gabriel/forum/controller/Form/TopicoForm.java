package com.gabriel.forum.controller.Form;

import com.gabriel.forum.modelo.Curso;
import com.gabriel.forum.modelo.Topico;
import com.gabriel.forum.repositories.CursoRepository;

public class TopicoForm {

    private String titulo;
    private String mensagem;
    private String nomeCurso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Topico converter(CursoRepository cusroRepository) {
       Curso curso = cusroRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
