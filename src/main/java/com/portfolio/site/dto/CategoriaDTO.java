package com.portfolio.site.dto;

import com.portfolio.site.entities.Categoria;

public class CategoriaDTO {
    private Long id;
    private String nome;

    public CategoriaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO(Categoria entidade) {
        id = entidade.getId();
        nome = entidade.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
