package com.dev.backend.controller;

import com.dev.backend.api.request.PermissaoRequest;
import com.dev.backend.api.response.PermissaoResponse;
import com.dev.backend.domain.entity.service.PermissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
@RequiredArgsConstructor
public class PermissaoController {

    private final PermissaoService service;

    @PostMapping
    public ResponseEntity<PermissaoResponse> create(@RequestBody PermissaoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<PermissaoResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
}
