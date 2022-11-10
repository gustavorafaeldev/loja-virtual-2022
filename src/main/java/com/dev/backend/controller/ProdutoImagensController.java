package com.dev.backend.controller;

import com.dev.backend.api.request.ProdutoImagensRequest;
import com.dev.backend.api.response.ProdutoImagensResponse;
import com.dev.backend.domain.entity.service.ProdutoImagensService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/produto/imagens")
@RequiredArgsConstructor
public class ProdutoImagensController {

    private final ProdutoImagensService service;

    @PostMapping
    public ResponseEntity<ProdutoImagensResponse> create(@RequestParam("idProduto") Long idProduto,
            @RequestParam("file") MultipartFile file) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(idProduto, file));
    }
}
