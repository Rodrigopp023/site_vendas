package com.portfolio.site.dto;

import com.portfolio.site.entities.Usuario;

public class UsuarioDTO {
    private Long id;
    private String nome;

    public UsuarioDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UsuarioDTO(Usuario entidade) {
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
