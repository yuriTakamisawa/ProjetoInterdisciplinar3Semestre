package com.fatec.produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrinho;
    private Long idPedido;
    private Long idProduto;
    private int quantidade;

    public Carrinho(Long idPedido, Long idProduto, int quantidade) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Carrinho() {
        // Construtor padrão vazio
    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        try {
            if (quantidade <= 0) {
                throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
            } else {
                this.quantidade = quantidade;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
    }
}
