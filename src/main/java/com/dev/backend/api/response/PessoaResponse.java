package com.dev.backend.api.response;

import com.dev.backend.domain.entity.Cidade;
import com.dev.backend.domain.entity.PermissaoPessoa;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class PessoaResponse {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String codigoRecuperacaoSenha;
    private Date dataEnvioCodigo;
    private String endereco;
    private String cep;
    private Cidade cidade;
    private List<PermissaoPessoa> permissaoPessoas;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
