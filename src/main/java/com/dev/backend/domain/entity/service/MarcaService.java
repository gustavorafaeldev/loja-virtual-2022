package com.dev.backend.domain.entity.service;

import com.dev.backend.api.mapper.MarcaMapper;
import com.dev.backend.api.request.MarcaRequest;
import com.dev.backend.api.response.MarcaResponse;
import com.dev.backend.domain.entity.Marca;
import com.dev.backend.domain.entity.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarcaService {

    private final MarcaRepository repository;
    private final MarcaMapper mapper;

    public MarcaResponse create(MarcaRequest request) {
        request.setDataCriacao(new Date());
        Marca marca = mapper.toMarca(request);
        Marca marcaSalva = repository.save(marca);
        return mapper.toMarcaResponse(marcaSalva);
    }

    public List<MarcaResponse> findAll() {
        return repository.findAll().stream().map(mapper::toMarcaResponse).toList();
    }

    public MarcaResponse findById(Long id) {
        Optional<Marca> marca = repository.findById(id);
        return marca.map(mapper::toMarcaResponse).orElseThrow();
    }

    public MarcaResponse update(Long id, MarcaRequest request) {
        Optional<Marca> marca = repository.findById(id);
        if(marca.isPresent()) {
            if(request.getNome() != null) {
                marca.get().setNome(request.getNome());
            }
            marca.get().setDataAtualizacao(new Date());
            Marca marcaSalva = repository.save(marca.get());
            return mapper.toMarcaResponse(marcaSalva);
        }
        return null;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
