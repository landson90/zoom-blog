package com.escola.zoomapp.exception.enums;

import lombok.Getter;

@Getter
public enum ErrorMessageStatus {

    MSG_USUARIO_NAO_ENCONTRADO("Não encontramos usuário com código informado ."),
    MSG_POST_NAO_ENCONTRADO("Não encontramos post com código informado ."),
    MSG_EMIAL_CADASTRADO("E-mail já cadastrado");


    private String descrition;

    ErrorMessageStatus(String descrition) {
        this.descrition = descrition;
    }


}
