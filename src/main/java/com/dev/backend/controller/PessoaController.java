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
@RequestMapping("/api/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService service;

    @PostMapping
    public ResponseEntity<PessoaResponse> create(@RequestBody PessoaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> update(@PathVariable Long id, @RequestBody PessoaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
