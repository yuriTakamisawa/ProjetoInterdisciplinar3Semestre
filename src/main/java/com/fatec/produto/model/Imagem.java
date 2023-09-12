package com.fatec.produto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Imagem {
    
    @Id
    private long id;
    private String nome;
    private String caminho;
    @Column (name="arquivo", length=28672)
    private byte[] arquivo;
    
    public Imagem(){
        
    }
    public Imagem( Long id,String nome, String caminho, byte[] arquivo) {
        this.id=id;
        this.nome = nome;
        this.caminho = caminho;
        this.arquivo = arquivo;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCaminho() {
        return caminho;
    }
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    public byte[] getArquivo() {
        return arquivo;
    }
    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }


} 
