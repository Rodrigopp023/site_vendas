package com.portfolio.site.dto;

import com.portfolio.site.entities.AvaliacaoProduto;
import com.portfolio.site.entities.Categoria;
import com.portfolio.site.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String imagemUrl;
    private boolean disponivel;

    private List<CategoriaDTO> categorias = new ArrayList<>();
    private List<AvaliacaoProdutoDTO> avaliacaoProdutos = new ArrayList<>();

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto entidade) {
        id = entidade.getId();
        nome = entidade.getNome();
        descricao = entidade.getDescricao();
        preco = entidade.getPreco();
        imagemUrl = entidade.getImagemUrl();
        disponivel = entidade.isDisponivel();
        for (Categoria cat : entidade.getCategorias()) {
            categorias.add(new CategoriaDTO(cat));
        }
        for (AvaliacaoProduto avali : entidade.getAvaliacoes()) {
            avaliacaoProdutos.add(new AvaliacaoProdutoDTO(avali));
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public List<CategoriaDTO> getCategorias() {
        return categorias;
    }

    public List<AvaliacaoProdutoDTO> getAvaliacaoProdutos() {
        return avaliacaoProdutos;
    }
}

