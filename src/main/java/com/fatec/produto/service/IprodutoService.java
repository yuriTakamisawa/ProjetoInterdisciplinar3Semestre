package com.fatec.produto.service;

import java.util.List;

import com.fatec.produto.model.Catalogo;
import com.fatec.produto.model.Produto;

public interface IprodutoService {

    public List<Catalogo> listarCatalogo();

    Produto adicionarProduto(Produto produto);

    Produto listarProdutoPorId(Long id);

    Produto atualizarProduto(Produto produto);

    void deletarProduto(Long id);

    void deleteAll();

    public Object listarProdutos();

    List<Object> listarProdutosComImagens();
}
