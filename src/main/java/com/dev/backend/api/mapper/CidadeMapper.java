package com.dev.backend.api.mapper;

import com.dev.backend.api.request.CidadeRequest;
import com.dev.backend.api.response.CidadeResponse;
import com.dev.backend.domain.entity.Cidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CidadeMapper {

    private final ModelMapper mapper;

    public Cidade toCidade(CidadeRequest request) {
        return mapper.map(request, Cidade.class);
    }

    public CidadeResponse toCidadeResponse(Cidade cidade) {
        return mapper.map(cidade, CidadeResponse.class);
    }
}
