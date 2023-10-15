package com.fatec.produto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.produto.model.Produto;
import com.fatec.produto.model.Catalogo;
import com.fatec.produto.model.IimagemRepository;
import com.fatec.produto.model.Imagem;
import com.fatec.produto.model.IprodutoRepository;

@Service
public class ProdutoService implements IprodutoService {

    @Autowired
    private IprodutoRepository repositoryP;
    @Autowired
    private IimagemService imagemService;

    @Override
    public List<Object> listarProdutosComImagens() {
        List<Object> produtosComImagens = new ArrayList<>();

        List<Produto> listaProdutos = repositoryP.findAll();

        for (Produto produto : listaProdutos) {
            Imagem imagem = imagemService.getImagemByProdutoId(produto.getId());

            Map<String, Object> produtoComImagem = new HashMap<>();
            produtoComImagem.put("produto", produto);

            if (imagem != null) {
                produtoComImagem.put("imagem", imagem.getArquivo());
            }

            produtosComImagens.add(produtoComImagem);
        }

        return produtosComImagens;
    }

    @Override
    public Produto adicionarProduto(Produto produto) {
        return repositoryP.save(produto);
    }

    @Override
    public Produto listarProdutoPorId(Long id) {
        return repositoryP.findById(id).orElse(null); // Trate o caso em que o produto não existe
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return repositoryP.save(produto);
    }

    @Override
    public void deletarProduto(Long id) {
        repositoryP.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repositoryP.deleteAll();
    }

}
