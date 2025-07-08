package com.portfolio.site.dto;

import com.portfolio.site.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {
    private Long id;
    private String nome;

    private List<Produto> produtos = new ArrayList<>();

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
