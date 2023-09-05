package com.fatec.produto.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Faz com que o id seja incrementado automaticamente pelo JPA.
    private Long id;
    private String descricao;
    private String categoria;
    private String estado;
    private double custo;
    private int quantidadeEstoque;
    private LocalDate dataValidade;

    
    
    public Produto(String descricao, String categoria, String estado, double custo, int quantidadeEstoque, LocalDate dataValidade) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.estado = estado;
        this.custo = custo;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataValidade = dataValidade;
    }
    
    public Produto() {
        // Construtor padrão vazio
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

        if(descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição não pode estar nula.");
        } else {
            this.descricao = descricao;
        }
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        if(categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("A categoria não pode estar nula.");
        } else {
            this.categoria = categoria;
        }
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
         // Verifica se o estado é nulo ou vazio
        if (estado == null || estado.isBlank()) {
            this.estado = null; // Permite que o estado seja nulo
        } else {
        // Verifica se o estado é um dos valores esperados
        if (!estado.equals("Maduro") && !estado.equals("Verde") && !estado.equals("No Ponto")) {
            throw new IllegalArgumentException("O estado do produto deve ser 'Maduro', 'Verde' ou 'No Ponto'.");
        }
            this.estado = estado;
        }
    }


    public double getCusto() {
        return custo;
    }


    public void setCusto(double custo) {
        try {
            if(custo<=0){
                throw new IllegalArgumentException("O custo deve ser um número positivo.");
            } else {
                this.custo = custo;
            }
        } catch(Exception e) {
            throw new IllegalArgumentException("O custo deve ser um número positivo.");
        }
    }


    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }


    public void setQuantidadeEstoque(int quantidadeEstoque) {

         try {
            if(quantidadeEstoque<=0){
                throw new IllegalArgumentException("A quantidade no estoque deve ser maior que zero.");
            } else {
                this.quantidadeEstoque = quantidadeEstoque;
            }
        } catch(Exception e) {
            throw new IllegalArgumentException("A quantidade no estoque deve ser maior que zero.");
        }
        
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        if (dataValidade == null) {
            throw new IllegalArgumentException("A data de validade não pode estar nula.");
        }
        this.dataValidade = dataValidade;
    }




}
