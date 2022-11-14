package com.dev.backend.api.mapper;

import com.dev.backend.api.request.PessoaClienteRequest;
import com.dev.backend.api.request.PessoaRequest;
import com.dev.backend.api.response.PessoaResponse;
import com.dev.backend.domain.entity.Pessoa;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaMapper {

    private final ModelMapper mapper;

    public Pessoa toPessoa(PessoaRequest request) {
        return mapper.map(request, Pessoa.class);
    }

    public Pessoa toPessoa(PessoaClienteRequest request) {
        return mapper.map(request, Pessoa.class);
    }
    public Pessoa toPessoaCliente(PessoaClienteRequest request) {
        return mapper.map(request, Pessoa.class);
    }

    public PessoaResponse toPessoaResponse(Pessoa pessoa) {
        return mapper.map(pessoa, PessoaResponse.class);
    }

    public PessoaResponse toPessoaResponseCliente(PessoaClienteRequest request) {
        return mapper.map(request, PessoaResponse.class);
    }

    public PessoaRequest toPessoaRequest(Pessoa pessoa) {
        return mapper.map(pessoa, PessoaRequest.class);
    }
}
