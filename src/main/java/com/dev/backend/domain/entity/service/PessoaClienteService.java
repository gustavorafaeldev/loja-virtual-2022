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
import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> propeiedades = new HashMap<>();
        propeiedades.put("nome", pessoa.getNome());
        propeiedades.put("mensagem", "Registro realizado com sucesso. Em breve você recebera um e-mail para cadastrar " +
                "sua senha!");
        emailService.enviarEmailTemplate(pessoa.getEmail(), "Cadastro na Loja Tabajara", propeiedades);
        return mapper.toPessoaResponse(pessoa);
    }
}
