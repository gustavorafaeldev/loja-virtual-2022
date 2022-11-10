package com.dev.backend.controller;

import com.dev.backend.api.request.CidadeRequest;
import com.dev.backend.api.response.CidadeResponse;
import com.dev.backend.domain.entity.service.CidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
@RequiredArgsConstructor
public class CidadeController {

    private final CidadeService service;

    @PostMapping
    public ResponseEntity<CidadeResponse> create(@RequestBody CidadeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeResponse> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CidadeResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CidadeResponse> update(@PathVariable Long id, @RequestBody CidadeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deelte(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
