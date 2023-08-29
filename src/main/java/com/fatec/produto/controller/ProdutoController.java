package com.fatec.produto.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fatec.produto.model.Produto;
import com.fatec.produto.model.IprodutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private IprodutoRepository repository;

    ProdutoController(IprodutoRepository produtoRepository) {
        this.repository = produtoRepository;
    }

    @GetMapping
    public ResponseEntity<?> listarProdutos() {
        ResponseEntity<?> resp = null;
        try {
            List<Produto> list = repository.findAll();
            if (!list.isEmpty()) {
                resp = new ResponseEntity<List<Produto>>(list, HttpStatus.OK);
            } else {
                resp = new ResponseEntity<String>("Nenhum produto encontrado.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Opa, algo deu errado.", ex);
        }
        return resp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarProdutoPorId(@PathVariable Long id) {
        ResponseEntity<?> response = null;
        try {
            Produto produto = repository.findById(id).orElse(null);
            if (produto != null) {
                response = new ResponseEntity<Produto>(produto, HttpStatus.OK);
            } else {
                response = new ResponseEntity<String>("Nenhum produto encontrado.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Opa, algo deu errado.", e);
        }
        return response;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> adicionarProduto(@RequestBody Produto newProduto) {
        ResponseEntity<?> resp = null;
        Produto produto = null;
        try {
            produto = repository.save(newProduto);

            if (produto != null) {
                resp = new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
            } else {
                resp = new ResponseEntity<String>("Não foi possível criar um novo produto.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Opa, algo deu errado.", e);
        }
        return resp;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        try {
            Produto existingProduto = repository.findById(id).orElse(null);

            if (existingProduto != null) {
                existingProduto.setDescricao(produto.getDescricao());
                existingProduto.setCategoria(produto.getCategoria());
                existingProduto.setEstado(produto.getEstado());
                existingProduto.setCusto(produto.getCusto());
                existingProduto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
                existingProduto.setDataValidade(produto.getDataValidade());

                Produto updatedProduto = repository.save(existingProduto);
                return new ResponseEntity<Produto>(updatedProduto, HttpStatus.OK);
            } else {
                System.err.println("Produto de id: " + id + " não encontrado.");
                return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Opa, algo deu errado.", e);
        }
    }

    @PatchMapping
    public ResponseEntity<String> atualizarAtributoEspecifico(
            @RequestParam Long id,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) Double custo,
            @RequestParam(required = false) Integer quantidadeEstoque,
            @RequestParam(required = false) LocalDate dataValidade) {

        ResponseEntity<String> resp = null;

        try {
            Produto produto = repository.findById(id).orElse(null);

            if (produto != null) {
                if (descricao != null) {
                    produto.setDescricao(descricao);
                }
                if (categoria != null) {
                    produto.setCategoria(categoria);
                }
                if (estado != null) {
                    produto.setEstado(estado);
                }
                if (custo != null) {
                    produto.setCusto(custo);
                }
                if (quantidadeEstoque != null) {
                    produto.setQuantidadeEstoque(quantidadeEstoque);
                }
                if (dataValidade != null) {
                    produto.setDataValidade(dataValidade);
                }

                Produto updatedProduto = repository.save(produto);

                resp = new ResponseEntity<String>("Atributo(s) do produto de id " + id + " atualizado(s).",
                        HttpStatus.PARTIAL_CONTENT); // 206
            } else {
                resp = new ResponseEntity<String>("Produto de id " + id + " não encontrado.",
                        HttpStatus.NOT_FOUND); // 404
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Opa, algo deu errado.", e);
        }

        return resp;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return new ResponseEntity<String>("Produto de id: " + id + " removido com sucesso.", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Produto de id: " + id + " não encontrado.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Não foi possível apagar o produto de id: " + id,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        try {
            repository.deleteAll();
            return new ResponseEntity<String>("Todos os registros foram removidos.", HttpStatus.OK);
        } catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<String>("Nenhum registro encontrado para ser removido.", HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>("Não foi possível apagar os registros.",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
