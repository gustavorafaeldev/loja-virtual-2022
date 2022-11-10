package com.dev.backend.domain.entity.service;

import com.dev.backend.api.mapper.PessoaMapper;
import com.dev.backend.api.request.PessoaClienteRequest;
import com.dev.backend.api.response.PessoaResponse;
import com.dev.backend.domain.entity.Pessoa;
import com.dev.backend.domain.entity.repository.PermissaoRepository;
import com.dev.backend.domain.entity.repository.PessoaClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PessoaClienteService {

    private final PessoaClienteRepository repository;
    private final PessoaMapper mapper;

    private final PermissaoPessoaService permissaoPessoaService;

    public PessoaResponse registrar(PessoaClienteRequest request) {
        Pessoa pessoa = new Pessoa();
        pessoa.setDataCriacao(new Date());
        pessoa = repository.save(mapper.toPessoaCliente(request));
        permissaoPessoaService.vincularPessoaPermissaoCliente(mapper.toPessoaRequest(pessoa));
        return mapper.toPessoaResponse(pessoa);
    }


}
