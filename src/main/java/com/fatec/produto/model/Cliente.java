package com.fatec.produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;
    private String enderecoCliente;
    private String email;
    private String telefone;

    public Cliente() {
    }

    public Cliente(String nomeCliente, String enderecoCliente, String email, String telefone) {
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.isBlank()) {
            throw new IllegalArgumentException("O nome de usuário não pode estar nulo.");
        } else {
            this.nomeCliente = nomeCliente;
        }
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O email do usuário não pode estar nulo.");
        } else {
            this.email = email;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("O telefone do usuário não pode estar nulo.");
        } else {
            this.telefone = telefone;
        }
    }

}
