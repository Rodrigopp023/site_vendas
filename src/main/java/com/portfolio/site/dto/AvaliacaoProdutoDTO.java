package com.portfolio.site.dto;

import com.portfolio.site.entities.AvaliacaoProduto;

import java.time.Instant;

public class AvaliacaoProdutoDTO {
    private Long id;
    private Double nota;
    private String comentario;
    private Instant dataAvaliacao;
    private UsuarioDTO usuario;

    public AvaliacaoProdutoDTO() {
    }

    public AvaliacaoProdutoDTO(AvaliacaoProduto entidade) {
        id = entidade.getId();
        nota = entidade.getNota();
        comentario = entidade.getComentario();
        dataAvaliacao = entidade.getDataAvaliacao();
        usuario = new UsuarioDTO(entidade.getUsuario());
    }

    public Long getId() {
        return id;
    }

    public Double getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public Instant getDataAvaliacao() {
        return dataAvaliacao;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }
}
