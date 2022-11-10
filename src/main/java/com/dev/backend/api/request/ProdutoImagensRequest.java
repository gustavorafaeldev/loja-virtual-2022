package com.dev.backend.api.request;

import com.dev.backend.domain.entity.Produto;
import lombok.Data;

import java.util.Date;

@Data
public class ProdutoImagensRequest {

    private Produto produto;
    private String nome;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
