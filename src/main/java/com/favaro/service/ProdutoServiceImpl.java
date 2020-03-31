package com.favaro.service;

import com.favaro.model.Produto;
import com.favaro.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProdutoService")
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> getProduto() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto getProduto(int id) {
        return null;
    }

    @Override
    public Produto save(Produto person) {
        return produtoRepository.save(person);
    }

    @Override
    public void delete(int id) {

    }
}
