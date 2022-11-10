package com.dev.backend.api.request;

import lombok.Data;

import java.util.Date;

@Data
public class CategoriaRequest {

    private String nome;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
