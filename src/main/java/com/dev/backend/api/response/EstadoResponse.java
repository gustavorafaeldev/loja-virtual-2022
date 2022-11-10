package com.dev.backend.api.response;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoResponse {

    private Long id;
    private String nome;
    private String sigla;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
