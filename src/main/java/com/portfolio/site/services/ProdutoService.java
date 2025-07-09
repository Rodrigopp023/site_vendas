package com.portfolio.site.services;

import com.portfolio.site.dto.ProdutoDTO;
import com.portfolio.site.entities.Produto;
import com.portfolio.site.repositories.ProdutoRepository;
import com.portfolio.site.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
}
