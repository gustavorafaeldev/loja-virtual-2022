package com.dev.backend.api.mapper;

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

    public PessoaResponse toPessoaResponse(Pessoa pessoa) {
        return mapper.map(pessoa, PessoaResponse.class);
    }
}
