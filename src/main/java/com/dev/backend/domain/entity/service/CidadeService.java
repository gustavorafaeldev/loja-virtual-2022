package com.dev.backend.domain.entity.service;

import com.dev.backend.api.mapper.CidadeMapper;
import com.dev.backend.api.mapper.EstadoMapper;
import com.dev.backend.api.request.CidadeRequest;
import com.dev.backend.api.request.EstadoRequest;
import com.dev.backend.api.response.CidadeResponse;
import com.dev.backend.api.response.EstadoResponse;
import com.dev.backend.domain.entity.Cidade;
import com.dev.backend.domain.entity.Estado;
import com.dev.backend.domain.entity.repository.CidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository repository;
    private final CidadeMapper mapper;

    public CidadeResponse create(CidadeRequest request) {
        request.setDataCriacao(new Date());
        Cidade cidade = mapper.toCidade(request);
        Cidade cidadeSalva = repository.save(cidade);
        return mapper.toCidadeResponse(cidadeSalva);
    }

    public CidadeResponse findById(Long id) {
        Optional<Cidade> cidade = repository.findById(id);
        if (cidade.isPresent()) {
            cidade.get().setDataAtualizacao(new Date());
            Cidade cidadeSalva = repository.save(cidade.get());
            return mapper.toCidadeResponse(cidadeSalva);
        }
        return null;
    }
    public List<CidadeResponse> findAll() {
        List<Cidade> cidadeList = repository.findAll();
        return cidadeList.stream().map(mapper::toCidadeResponse).toList();
    }

    public CidadeResponse update(Long id, CidadeRequest request) {
        Optional<Cidade> cidade = repository.findById(id);
        if(cidade.isPresent()) {
            cidade.get().setDataAtualizacao(new Date());
            Cidade cidadeSalva = repository.save(cidade.get());
            return mapper.toCidadeResponse(cidadeSalva);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
