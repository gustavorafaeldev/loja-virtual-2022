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
    private final EmailService emailService;

    private final PermissaoPessoaService permissaoPessoaService;

    public PessoaResponse registrar(PessoaClienteRequest request) {
        Pessoa pessoa = new Pessoa();
        pessoa.setDataCriacao(new Date());
        pessoa = repository.save(mapper.toPessoaCliente(request));
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(), "Cadastro na Loja Tabajara",
                "O registro na loja foi realizado com sucesso! Em breve você receberá a senha de acesso " +
                        "por email");
        return mapper.toPessoaResponse(pessoa);
    }
}
