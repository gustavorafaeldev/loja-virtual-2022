package com.dev.backend.api.response;

import com.dev.backend.domain.entity.Estado;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class CidadeResponse {

    private Long id;
    private String nome;
    private Estado estado;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
