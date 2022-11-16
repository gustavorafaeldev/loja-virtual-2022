package com.dev.backend.controller;

import com.dev.backend.api.request.PessoaRequest;
import com.dev.backend.api.response.PessoaResponse;
import com.dev.backend.domain.entity.Pessoa;
import com.dev.backend.domain.entity.service.PessoaGerenciamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa-gerenciamento")
@RequiredArgsConstructor
public class PessoaGerenciamentoController {

    private final PessoaGerenciamentoService service;

    @PostMapping("/senha-codigo")
    public String recuperarCodigo(@RequestBody PessoaRequest request) {
        return service.solicitarCodigo(request.getEmail());
    }

    @PostMapping("/senha-alterar")
    public String alterarSenha(@RequestBody PessoaRequest request) {
        return service.alterarSenha(request);
    }
}
