package com.dev.backend.api.mapper;

import com.dev.backend.api.request.ProdutoRequest;
import com.dev.backend.api.response.ProdutoResponse;
import com.dev.backend.domain.entity.Produto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoMapper {

    private final ModelMapper mapper;

    public Produto toProduto(ProdutoRequest request) {
        return mapper.map(request, Produto.class);
    }

    public ProdutoResponse toProdutoResponse(Produto produto) {
        return mapper.map(produto, ProdutoResponse.class);
    }
}
