package com.portfolio.site.services;

import com.portfolio.site.dto.AvaliacaoProdutoDTO;
import com.portfolio.site.dto.CategoriaDTO;
import com.portfolio.site.dto.ProdutoDTO;
import com.portfolio.site.entities.AvaliacaoProduto;
import com.portfolio.site.entities.Categoria;
import com.portfolio.site.entities.Produto;
import com.portfolio.site.entities.Usuario;
import com.portfolio.site.repositories.ProdutoRepository;
import com.portfolio.site.services.exceptions.DatabaseException;
import com.portfolio.site.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;

    @Transactional(readOnly = true)
    public ProdutoDTO findById(Long id) {
        Produto produto = repositorio.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ProdutoDTO(produto);
    }

    @Transactional
    public ProdutoDTO insert(ProdutoDTO dto) {
        Produto entidade = new Produto();
        copiaDtoParaEntidade(dto, entidade);
        entidade = repositorio.save(entidade);
        return new ProdutoDTO(entidade);
    }

    @Transactional
    public ProdutoDTO update(Long id, ProdutoDTO dto) {
        try {
            Produto entidade = repositorio.getReferenceById(id);
            copiaDtoParaEntidade(dto, entidade);
            entidade = repositorio.save(entidade);
            return new ProdutoDTO(entidade);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não enontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repositorio.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não enontrado");
        }
        try {
            repositorio.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copiaDtoParaEntidade(ProdutoDTO dto, Produto endidade) {
        endidade.setNome(dto.getNome());
        endidade.setDescricao(dto.getDescricao());
        endidade.setPreco(dto.getPreco());
        endidade.setImagemUrl(dto.getImagemUrl());
        endidade.setDisponivel(dto.isDisponivel());

        endidade.getCategorias().clear();
        for (CategoriaDTO catDto : dto.getCategorias()) {
            Categoria cat = new Categoria();
            cat.setId(catDto.getId());
            cat.setNome(catDto.getNome());
            endidade.getCategorias().add(cat);
        }

        endidade.getAvaliacoes().clear();
        for (AvaliacaoProdutoDTO avaDto : dto.getAvaliacaoProdutos()) {
            AvaliacaoProduto avali= new AvaliacaoProduto();
            avali.setId(avaDto.getId());
            avali.setNota(avaDto.getNota());
            avali.setComentario(avaDto.getComentario());
            avali.setDataAvaliacao(avaDto.getDataAvaliacao());
            endidade.getAvaliacoes().add(avali);

            Usuario usuario = new Usuario();
            usuario.setId(avaDto.getUsuario().getId());
            usuario.setNome(avaDto.getUsuario().getNome());
            avali.setUsuario(usuario);
            endidade.getAvaliacoes().add(avali);
        }
    }
}
