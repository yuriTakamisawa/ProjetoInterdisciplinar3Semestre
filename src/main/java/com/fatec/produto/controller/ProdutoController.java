package com.fatec.produto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.fatec.produto.model.Produto;
import com.fatec.produto.repository.ProdutoRepository;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    private ProdutoRepository repository;

    ProdutoController (ProdutoRepository produtoRepository) {
        this.repository = produtoRepository;
    }


    // Métodos Crud abaixo:


    @GetMapping
    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping 
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @PutMapping("/{id}")
    public Produto alterarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        if (id > 0) {
            produto.setId(id);
            return repository.save(produto);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Long id) {
        if (id > 0) {
            repository.deleteById(id);
            return "Produto removido com sucesso.";
        } else {
            return "Produto não encontrado.";
        }
    }

}
