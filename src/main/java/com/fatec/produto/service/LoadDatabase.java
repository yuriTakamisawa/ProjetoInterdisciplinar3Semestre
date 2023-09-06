package com.fatec.produto.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fatec.produto.model.IprodutoRepository;
import com.fatec.produto.model.Produto;
import java.time.LocalDate;


import com.fatec.produto.model.IclienteRepository;
import com.fatec.produto.model.Cliente;



@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initProdutoDatabase(IprodutoRepository produtoRepository) {
        return args -> {
            List<Produto> produtos = Arrays.asList(
                new Produto("Pera", "Fruta", "No Ponto", 4.5, 130, LocalDate.parse("2023-07-15")),
                new Produto("Banana", "Fruta", "Maduro", 1.0, 150, LocalDate.parse("2023-08-31")),
                new Produto("Mamão", "Fruta", "Maduro", 10.0, 100, LocalDate.parse("2023-10-10")));

            produtoRepository.saveAll(produtos);
        };
    }

    @Bean
    CommandLineRunner initClienteDatabase(IclienteRepository clienteRepository) {
        return args -> {
            List<Cliente> clientes = Arrays.asList(
                new Cliente("João", "Rua A", "joao@email.com", "123456789"),
                new Cliente("Maria", "Rua B", "maria@email.com", "987654321"));

            clienteRepository.saveAll(clientes);
        };
    }
}