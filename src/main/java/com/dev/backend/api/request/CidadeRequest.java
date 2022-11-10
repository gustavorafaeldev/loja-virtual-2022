package com.dev.backend.api.request;

import com.dev.backend.domain.entity.Estado;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class CidadeRequest {

    private String nome;
    @ManyToOne
    @JoinColumn(name = "idEstado")
    private Estado estado;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
