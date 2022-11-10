package com.dev.backend.domain.entity.service;

import com.dev.backend.api.mapper.CategoriaMapper;
import com.dev.backend.api.request.CategoriaRequest;
import com.dev.backend.api.response.CategoriaResponse;
import com.dev.backend.domain.entity.Categoria;
import com.dev.backend.domain.entity.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaResponse create(CategoriaRequest request) {
        request.setDataCriacao(new Date());
        Categoria categoriaSalva = repository.save(mapper.toCategoria(request));
        return mapper.toCategoriaResponse(categoriaSalva);
    }

    public CategoriaResponse findById(Long id) {
        Optional<Categoria> categoria = repository.findById(id);
        return mapper.toCategoriaResponse(categoria.get());
    }

    public List<CategoriaResponse> findAll() {
        List<Categoria> categoriaList = repository.findAll();
        return categoriaList.stream().map(mapper::toCategoriaResponse).toList();
    }

    public CategoriaResponse update(Long id, CategoriaRequest request) {
        Optional<Categoria> categoria = repository.findById(id);
        if(categoria.isPresent()) {
            if(request.getNome() != null) {
                categoria.get().setNome(request.getNome());
            }
            categoria.get().setDataAtualizacao(new Date());
            Categoria categoriaSave = repository.save(categoria.get());
            return mapper.toCategoriaResponse(categoriaSave);
        }
        return null;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
