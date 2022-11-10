package com.dev.backend.api.mapper;

import com.dev.backend.api.request.MarcaRequest;
import com.dev.backend.api.response.MarcaResponse;
import com.dev.backend.domain.entity.Marca;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarcaMapper {

    private final ModelMapper mapper;

    public Marca toMarca(MarcaRequest request) {
        return mapper.map(request, Marca.class);
    }

    public MarcaResponse toMarcaResponse(Marca marca) {
        return mapper.map(marca, MarcaResponse.class);
    }
}
