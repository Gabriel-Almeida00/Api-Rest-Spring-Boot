package com.gabriel.forum.controller.Form;

import com.gabriel.forum.modelo.Curso;
import com.gabriel.forum.modelo.Topico;
import com.gabriel.forum.repositories.CursoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class TopicoForm {

    @NotBlank
    @NotEmpty @Length(min = 5)
    private String titulo;
    @NotNull
    @NotEmpty @Length(min = 5)
    private String mensagem;
   @NotNull @NotEmpty @Length(min = 5)
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
