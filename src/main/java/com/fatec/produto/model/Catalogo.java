package com.fatec.produto.model;

public class Catalogo {
    private Long id;
    private String descricao;
    private String categoria;
    private Double custo;
    private int quantidadeEstoque;
    private byte[] imagem;


    public Catalogo() {
    }

    public Catalogo(Long id, String descricao, String categoria, Double custo, int quantidadeEstoque, byte[] imagem) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.custo = custo;
        this.quantidadeEstoque = quantidadeEstoque;
        this.imagem = imagem;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    




}