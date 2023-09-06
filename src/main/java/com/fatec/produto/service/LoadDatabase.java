package com.fatec.produto.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fatec.produto.model.IprodutoRepository;
import com.fatec.produto.model.Produto;
import java.time.LocalDate;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(IprodutoRepository repository) {
        return args -> {
            List<Produto> produtos = Arrays.asList(
                    new Produto("Pera", "Fruta", "No Ponto", 4.5, 130, LocalDate.parse("2023-07-15")),
                    new Produto("Banana", "Fruta", "Maduro", 1.0, 150, LocalDate.parse("2023-08-31")),
                    new Produto("Mamao", "Fruta", "Maduro", 10.0, 100, LocalDate.parse("2023-10-10")));

            repository.saveAll(produtos);
        };
    }

};