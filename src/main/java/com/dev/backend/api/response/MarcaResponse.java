package com.dev.backend.api.response;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class MarcaResponse {

    private Long id;
    private String nome;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
