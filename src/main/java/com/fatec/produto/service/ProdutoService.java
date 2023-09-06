package com.fatec.produto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.produto.model.Produto;
import com.fatec.produto.model.IprodutoRepository;

@Service
public class ProdutoService implements IprodutoService {

    @Autowired
    private IprodutoRepository repository;

    @Override
    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    @Override
    public Produto adicionarProduto(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public Produto listarProdutoPorId(Long id) {
        return repository.findById(id).orElse(null); // Trate o caso em que o produto não existe
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public void deletarProduto(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
