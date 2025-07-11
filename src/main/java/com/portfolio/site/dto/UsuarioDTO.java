package com.portfolio.site.dto;

import com.portfolio.site.entities.Usuario;

public class UsuarioDTO {
    private Long id;
    private String nome;

    public UsuarioDTO() {
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
