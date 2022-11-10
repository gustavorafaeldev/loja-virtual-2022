package com.dev.backend.api.mapper;

import com.dev.backend.api.request.ProdutoImagensRequest;
import com.dev.backend.api.response.ProdutoImagensResponse;
import com.dev.backend.domain.entity.ProdutoImagens;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoImagensMapper {

    private final ModelMapper mapper;

    public ProdutoImagens toProdutoImagens(ProdutoImagensRequest request) {
        return mapper.map(request, ProdutoImagens.class);
    }

    public ProdutoImagensResponse toProdutoImagensResponse(ProdutoImagens produtoImagens) {
        return mapper.map(produtoImagens, ProdutoImagensResponse.class);
    }
}
