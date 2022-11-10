package com.dev.backend.api.request;

import com.dev.backend.domain.entity.Cidade;
import lombok.Data;

@Data
public class PessoaClienteRequest {

    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private Cidade cidade;
}
