package com.dev.backend.domain.entity.service;

import com.dev.backend.api.mapper.ProdutoMapper;
import com.dev.backend.api.request.ProdutoRequest;
import com.dev.backend.api.response.ProdutoResponse;
import com.dev.backend.domain.entity.Produto;
import com.dev.backend.domain.entity.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoResponse create(ProdutoRequest request) {
        request.setDataCriacao(new Date());
        Produto produtoSalvo = repository.save(mapper.toProduto(request));
        return mapper.toProdutoResponse(produtoSalvo);
    }

    public ProdutoResponse findById(Long id) {
        Optional<Produto> produto = repository.findById(id);
        return mapper.toProdutoResponse(produto.get());
    }

    public List<ProdutoResponse> findAll() {
        List<Produto> produtos = repository.findAll();
        return produtos.stream().map(mapper::toProdutoResponse).toList();
    }

    public ProdutoResponse update(Long id, ProdutoRequest request) {
        Optional<Produto> produto = repository.findById(id);
        if(produto.isPresent()) {
            produto.get().setDataAtualizacao(new Date());
            Produto produtoSalvo = repository.save(produto.get());
            return mapper.toProdutoResponse(produtoSalvo);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
