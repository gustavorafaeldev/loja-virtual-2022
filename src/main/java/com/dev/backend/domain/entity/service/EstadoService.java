package com.dev.backend.domain.entity.service;

import com.dev.backend.api.mapper.EstadoMapper;
import com.dev.backend.api.request.EstadoRequest;
import com.dev.backend.api.response.EstadoResponse;
import com.dev.backend.domain.entity.Estado;
import com.dev.backend.domain.entity.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstadoService {

    //crud
    private final EstadoRepository repository;
    private final EstadoMapper mapper;

    public EstadoResponse create(EstadoRequest request) {
        request.setDataCriacao(new Date());
        Estado estado = mapper.toEstado(request);
        Estado estadoSalvo = repository.save(estado);
        return mapper.toEstadoResponse(estadoSalvo);
    }

    public List<EstadoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toEstadoResponse).toList();
    }

    public EstadoResponse findById(Long id) {
        Optional<Estado> estado = repository.findById(id);
        return estado.map(mapper::toEstadoResponse).orElse(null);
    }

    public EstadoResponse update(Long id, EstadoRequest request) {
        Optional<Estado> estado = repository.findById(id);

        if(estado.isPresent()){
            if(request.getNome() != null) {
                estado.get().setNome(request.getNome());
            }
            if(request.getSigla() != null) {
                estado.get().setSigla(request.getSigla());
            }
            estado.get().setDataAtualizacao(new Date());
            Estado estadoSalvo = repository.save(estado.get());
            return mapper.toEstadoResponse(estadoSalvo);
        }
        return null;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
