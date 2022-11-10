package com.dev.backend.api.request;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoRequest {

    private String nome;
    private String sigla;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
