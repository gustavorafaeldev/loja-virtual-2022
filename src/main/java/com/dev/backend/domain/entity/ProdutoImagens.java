package com.dev.backend.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "produto_imagens")
public class ProdutoImagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;
    private String nome;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
