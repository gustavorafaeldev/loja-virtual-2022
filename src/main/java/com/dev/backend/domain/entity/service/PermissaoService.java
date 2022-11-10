package com.dev.backend.domain.entity.service;

import com.dev.backend.api.mapper.PermissaoMapper;
import com.dev.backend.api.request.PermissaoRequest;
import com.dev.backend.api.response.PermissaoResponse;
import com.dev.backend.domain.entity.Permissao;
import com.dev.backend.domain.entity.repository.PermissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissaoService {

    private final PermissaoRepository repository;
    private final PermissaoMapper mapper;

    public PermissaoResponse create(PermissaoRequest request) {
        request.setDataCriacao(new Date());
        Permissao permissao = repository.save(mapper.toPermissao(request));
        return mapper.toPermissaoResponse(permissao);
    }

    public PermissaoResponse findById(Long id) {
        Optional<Permissao> optionalPermissao = repository.findById(id);
        return mapper.toPermissaoResponse(optionalPermissao.get());
    }

    public List<PermissaoResponse> findAll() {
        List<Permissao> permissaoList = repository.findAll();
        return permissaoList.stream().map(mapper::toPermissaoResponse).toList();
    }

    public PermissaoResponse update(Long id, PermissaoRequest request) {
        Optional<Permissao> optionalPermissao = repository.findById(id);
        optionalPermissao.get().setDataAtualizacao(new Date());
        Permissao permissao = repository.save(optionalPermissao.get());
        return mapper.toPermissaoResponse(permissao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
