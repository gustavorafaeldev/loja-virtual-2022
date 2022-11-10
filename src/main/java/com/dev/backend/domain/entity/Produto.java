package com.dev.backend.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricaoCurta;
    private String descricaoDetalhada;
    private Double valorCusto;
    private Double valorvenda;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Categoria categoria;
    private Date dataCriacao;
    private Date dataAtualizacao;

}
