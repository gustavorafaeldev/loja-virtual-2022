package com.dev.backend.api.request;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class MarcaRequest {

    private String nome;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
