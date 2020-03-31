package com.favaro.service;

import com.favaro.model.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> getProduto();
    Produto getProduto(int id);
    Produto save(Produto produto);
    void delete(int id);
}
