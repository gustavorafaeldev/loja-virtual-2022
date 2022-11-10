package com.dev.backend.domain.entity.service;

import com.dev.backend.api.mapper.PessoaMapper;
import com.dev.backend.api.request.PessoaClienteRequest;
import com.dev.backend.api.request.PessoaRequest;
import com.dev.backend.api.response.PessoaResponse;
import com.dev.backend.domain.entity.Pessoa;
import com.dev.backend.domain.entity.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;
    private final PessoaMapper mapper;

    public PessoaResponse create(PessoaRequest request) {
        request.setDataCriacao(new Date());
        Pessoa pessoaSalva = repository.save(mapper.toPessoa(request));
        return mapper.toPessoaResponse(pessoaSalva);
    }

    public List<PessoaResponse> findAll() {
        List<Pessoa> pessoaList = repository.findAll();
        return pessoaList.stream().map(mapper::toPessoaResponse).toList();
    }

    public PessoaResponse findById(Long id) {
        Optional<Pessoa> pessoa = repository.findById(id);
        return mapper.toPessoaResponse(pessoa.get());
    }

    public PessoaResponse update(Long id, PessoaRequest request) {
        Optional<Pessoa> pessoa = repository.findById(id);
        if(pessoa.isPresent()) {
            pessoa.get().setDataAtualizacao(new Date());
            Pessoa pessoaSalva = repository.save(pessoa.get());
            return mapper.toPessoaResponse(pessoaSalva);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
