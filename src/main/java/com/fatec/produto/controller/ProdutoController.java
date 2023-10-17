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
