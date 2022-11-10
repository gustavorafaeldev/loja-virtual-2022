package com.dev.backend.api.response;

import com.dev.backend.domain.entity.Produto;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ProdutoImagensResponse {

    private Long id;
    private String nome;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private Produto produto;

}
