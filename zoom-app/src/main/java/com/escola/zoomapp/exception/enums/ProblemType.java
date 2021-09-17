package com.escola.zoomapp.exception.enums;

import lombok.Getter;

@Getter
public enum ProblemType {

    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada"),
    DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
    EMAIL_INVALIDO("/email-invalido", "Email existente");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://zoom.com.br" + path;
        this.title = title;
    }
}
