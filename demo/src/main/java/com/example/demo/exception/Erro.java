package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Erro {

    public Erro(final String propriedade, final String mensagem) {
        this.propriedade = propriedade;
        this.mensagem = mensagem;
    }

    private String propriedade;
    private String mensagem;
}