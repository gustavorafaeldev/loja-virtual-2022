package com.dev.backend.api.mapper;

import com.dev.backend.api.request.CategoriaRequest;
import com.dev.backend.api.response.CategoriaResponse;
import com.dev.backend.domain.entity.Categoria;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoriaMapper {

    private final ModelMapper mapper;

    public Categoria toCategoria(CategoriaRequest request) {
        return mapper.map(request, Categoria.class);
    }

    public CategoriaResponse toCategoriaResponse(Categoria categoria) {
        return mapper.map(categoria, CategoriaResponse.class);
    }
}
