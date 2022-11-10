package com.dev.backend.api.mapper;

import com.dev.backend.api.request.PermissaoRequest;
import com.dev.backend.api.response.PermissaoResponse;
import com.dev.backend.domain.entity.Permissao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PermissaoMapper {

    private final ModelMapper mapper;

    public Permissao toPermissao(PermissaoRequest request) {
        return mapper.map(request, Permissao.class);
    }

    public PermissaoResponse toPermissaoResponse(Permissao permissao) {
        return mapper.map(permissao, PermissaoResponse.class);
    }
}
