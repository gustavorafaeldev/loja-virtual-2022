package com.dev.backend.domain.entity.service;

import com.dev.backend.api.mapper.PessoaMapper;
import com.dev.backend.api.request.PessoaRequest;
import com.dev.backend.domain.entity.Permissao;
import com.dev.backend.domain.entity.PermissaoPessoa;
import com.dev.backend.domain.entity.repository.PermissaoPessoaRepository;
import com.dev.backend.domain.entity.repository.PermissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissaoPessoaService {

    private final PermissaoPessoaRepository repository;
    private final PermissaoRepository permissaoRepository;
    private final PessoaMapper mapper;

    public void vincularPessoaPermissaoCliente(PessoaRequest request) {
        List<Permissao> listaPermissao = permissaoRepository.findByNome("CLIENTE");
        if(listaPermissao.size()>0) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(mapper.toPessoa(request));
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            repository.save(permissaoPessoa);
        }
    }
}
