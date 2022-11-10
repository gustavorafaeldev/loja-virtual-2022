package com.dev.backend.controller;

import com.dev.backend.api.request.PessoaRequest;
import com.dev.backend.api.response.PessoaResponse;
import com.dev.backend.domain.entity.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class PessoaClienteController {

    private final PessoaService service;

    @PostMapping
    public ResponseEntity<PessoaResponse> create(@RequestBody PessoaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

}
