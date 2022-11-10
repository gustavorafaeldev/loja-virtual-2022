package com.dev.backend.domain.entity.service;

import com.dev.backend.api.mapper.ProdutoImagensMapper;
import com.dev.backend.api.request.ProdutoImagensRequest;
import com.dev.backend.api.response.ProdutoImagensResponse;
import com.dev.backend.domain.entity.Produto;
import com.dev.backend.domain.entity.ProdutoImagens;
import com.dev.backend.domain.entity.repository.ProdutoImagensRepository;
import com.dev.backend.domain.entity.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoImagensService {

    private final ProdutoImagensRepository repository;
    private final ProdutoRepository produtoRepository;
    private final ProdutoImagensMapper mapper;

    public ProdutoImagensResponse create(Long idProduto, MultipartFile file) {

        Produto produto = produtoRepository.findById(idProduto).get();

        ProdutoImagensRequest request = new ProdutoImagensRequest();

        try {
            if(!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("E:/imagens/" + nomeImagem);
                Files.write(caminho, bytes);
                request.setNome(nomeImagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.setProduto(produto);
        request.setDataCriacao(new Date());
        ProdutoImagens produtoImagens = repository.save(mapper.toProdutoImagens(request));
        return mapper.toProdutoImagensResponse(produtoImagens);
    }
}
