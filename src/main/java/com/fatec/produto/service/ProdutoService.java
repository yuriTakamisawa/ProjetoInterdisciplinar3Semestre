package com.fatec.produto.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.produto.model.Produto;
import com.fatec.produto.model.IprodutoRepository;

@Service
public class ProdutoService implements IprodutoService {

    private static final Logger logger = LogManager.getLogger(ProdutoService.class);

    @Autowired
    private IprodutoRepository iprodutoRepository;

    @Override
    public List<Produto> listarProdutos() {
        return iprodutoRepository.findAll();
    }

    @Override
    public Produto adicionarProduto(Produto produto) {
        return iprodutoRepository.save(produto);
    }

    @Override
    public Produto listarProdutoPorId(Long id) {
        return iprodutoRepository.findById(id).orElse(null); // Trate o caso em que o produto não existe
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return iprodutoRepository.save(produto);
    }

    @Override
    public void deletarProduto(Long id) {
        iprodutoRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        iprodutoRepository.deleteAll();
    }
}
