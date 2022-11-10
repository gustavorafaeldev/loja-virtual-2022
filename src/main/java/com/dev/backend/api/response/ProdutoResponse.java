package com.dev.backend.api.response;

import com.dev.backend.domain.entity.Categoria;
import com.dev.backend.domain.entity.Marca;
import lombok.Data;

import java.util.Date;

@Data
public class ProdutoResponse {

    private Long id;
    private String descricaoCurta;
    private String descricaoDetalhada;
    private Double valorCusto;
    private Double valorvenda;
    private Marca marca;
    private Categoria categoria;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
