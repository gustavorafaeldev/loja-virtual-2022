package com.dev.backend.api.mapper;

import com.dev.backend.api.request.EstadoRequest;
import com.dev.backend.api.response.EstadoResponse;
import com.dev.backend.domain.entity.Estado;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EstadoMapper {

    private final ModelMapper mapper;

    public Estado toEstado(EstadoRequest request) {
        return mapper.map(request, Estado.class);
    }

    public EstadoResponse toEstadoResponse(Estado estado) {
        return mapper.map(estado, EstadoResponse.class);
    }
}
