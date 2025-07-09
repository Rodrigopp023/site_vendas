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

    private List<Categoria> categorias = new ArrayList<>();
    private List<AvaliacaoProduto> avaliacaoProdutos = new ArrayList<>();

    public ProdutoDTO(Long id, String nome, String descricao, Double preco,
                      String imagemUrl, boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagemUrl = imagemUrl;
        this.disponivel = disponivel;
    }

    public ProdutoDTO(Produto entidade) {
        id = entidade.getId();
        nome = entidade.getNome();
        descricao = entidade.getDescricao();
        preco = entidade.getPreco();
        imagemUrl = entidade.getImagemUrl();
        disponivel = entidade.isDisponivel();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<AvaliacaoProduto> getAvaliacaoProdutos() {
        return avaliacaoProdutos;
    }
}

