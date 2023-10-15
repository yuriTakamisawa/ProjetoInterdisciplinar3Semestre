package com.fatec.produto.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fatec.produto.service.IprodutoService;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	IprodutoService produtoService;

	/*
	 * consulta catalogo retorna um arquivo json de produtos
	 */
	@CrossOrigin
	@GetMapping
	public ResponseEntity<Object> consultaTodos() {
		logger.info(">>>>>> apicontroller consulta todos produtos");
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarProdutosComImagens());
	}

	// @PostMapping
	// public ResponseEntity<Object> adicionarProduto(@RequestBody Produto produto)
	// {
	// logger.info("ProdutoController adicionar produto");
	// Produto novoProduto = produtoService.adicionarProduto(produto);
	// return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
	// }
}

// @RestController
// @RequestMapping("api/v1/produtos")
// @CrossOrigin
// public class ProdutoController {

// private static final Logger logger =
// LogManager.getLogger(ProdutoController.class);

// private final IprodutoService produtoService;

// @Autowired
// public ProdutoController(IprodutoService produtoService) {
// this.produtoService = produtoService;
// }

// @GetMapping
// public ResponseEntity<List<Produto>> listarProdutos() {
// logger.info("ProdutoController listar produtos");
// List<Produto> produtos = produtoService.listarProdutos();
// return new ResponseEntity<>(produtos, HttpStatus.OK);
// }

// @GetMapping("/{id}")
// public ResponseEntity<Produto> listarProdutoPorId(@PathVariable Long id) {
// logger.info("ProdutoController listar produto por ID: {}", id);
// Produto produto = produtoService.listarProdutoPorId(id);
// if (produto != null) {
// return new ResponseEntity<>(produto, HttpStatus.OK);
// } else {
// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// }
// }

//

// @PutMapping("/{id}")
// public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id,
// @RequestBody Produto produto) {
// logger.info("ProdutoController atualizar produto: {}", id);
// Produto produtoExistente = produtoService.listarProdutoPorId(id);
// if (produtoExistente != null) {
// produto.setId(id);
// Produto produtoAtualizado = produtoService.atualizarProduto(produto);
// return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
// } else {
// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// }
// }

// @DeleteMapping("/{id}")
// public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
// logger.info("ProdutoController deletar produto: {}", id);
// Produto produtoExistente = produtoService.listarProdutoPorId(id);
// if (produtoExistente != null) {
// produtoService.deletarProduto(id);
// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// } else {
// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// }
// }

// @DeleteMapping
// public ResponseEntity<Void> deleteAll() {
// logger.info("ProdutoController deletar todos os produtos");
// produtoService.deleteAll();
// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// }
// }