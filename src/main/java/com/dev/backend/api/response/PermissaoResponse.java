package com.dev.backend.api.response;

import lombok.Data;

import java.util.Date;

@Data
public class PermissaoResponse {

    private Long id;
    private String nome;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
