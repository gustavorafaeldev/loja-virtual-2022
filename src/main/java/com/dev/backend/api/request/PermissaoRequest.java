package com.dev.backend.api.request;

import lombok.Data;

import java.util.Date;

@Data
public class PermissaoRequest {

    private String nome;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
