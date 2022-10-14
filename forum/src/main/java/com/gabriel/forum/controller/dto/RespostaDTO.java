package com.gabriel.forum.controller.dto;

import com.gabriel.forum.modelo.Resposta;

import java.time.LocalDateTime;

public class    RespostaDTO {

    private Long id;
    private String mensagem;
    private LocalDateTime dataCraicao;
    private String nomeAutor;

    public RespostaDTO(Resposta resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCraicao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCraicao() {
        return dataCraicao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
