package com.fatec.produto.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.fatec.produto.model.Produto;

public interface IprodutoService {

    public List<Produto> listarProdutos();
    public Optional <Produto> adicionarProduto();
    public Optional <Produto> listarProdutoPorId(Long id);
    public Optional <Produto> deletarProduto(Long id);
    public Optional <Produto> deleteAll();
    public Optional <Produto> atualizarAtributoEspecifico(/*  String descricao,String categoria,String estado, Double custo,Integer quantidadeEstoque, LocalDate dataValidade */);
    public Optional <Produto> atualizarProduto(Long id);


}


