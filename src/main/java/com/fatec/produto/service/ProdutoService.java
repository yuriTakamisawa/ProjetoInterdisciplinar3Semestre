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
    public Object listarProdutos() {

        return repositoryP.findAll();
    }

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
    public List<Catalogo> listarCatalogo() {
        List<Catalogo> lista = new ArrayList<>();
        List<Produto> listaProdutos = repositoryP.findAll();
        List<Imagem> listaImagens = imagemService.getAll();

        for (Produto produto : listaProdutos) {
            for (Imagem imagem : listaImagens) {
                if (produto.getId().equals(imagem.getId())) {
                    Catalogo catalogo = new Catalogo(
                            produto.getId(),
                            produto.getDescricao(),
                            produto.getCategoria(),
                            produto.getEstado(),
                            produto.getCusto(),
                            produto.getQuantidadeEstoque(),
                            produto.getDataValidade(),
                            imagem.getArquivo());
                    lista.add(catalogo);
                }
            }
        }
        return lista;
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
