package com.fatec.produto.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fatec.produto.model.Imagem;
import com.fatec.produto.model.Produto;
import com.fatec.produto.model.IimagemRepository;
import com.fatec.produto.model.IprodutoRepository;

@Configuration
public class LoadDatabase {

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IimagemRepository imagemRepository;

    @Bean
    CommandLineRunner initProdutoDatabase(IprodutoRepository produtoRepository) {
        return args -> {
            List<Produto> produtos = Arrays.asList(
                    new Produto("Pera", "Fruta", "No Ponto", 4.5, 130, LocalDate.parse("2023-07-15")),
                    new Produto("Banana", "Fruta", "Maduro", 1.0, 150, LocalDate.parse("2023-08-31")),
                    new Produto("Mamão", "Fruta", "Maduro", 10.0, 100, LocalDate.parse("2023-10-10")));

            produtoRepository.saveAll(produtos);

            // Carregar e salvar as imagens
            Path path = Paths.get("c:/temp/produto1.jpg");
            try (InputStream file = Files.newInputStream(path)) {
                byte[] arquivo1 = file.readAllBytes();
                Imagem imagem = new Imagem();
                imagem.setId(1L); // associa o id do produto ao id da imagem
                imagem.setNome("produto1.jpg");
                imagem.setCaminho("imagens/" + imagem.getNome());
                imagem.setArquivo(arquivo1);
                logger.info(">>>>> loaddatabase -> upload de arquivo imagem realizado => " + arquivo1.length);
                imagemRepository.save(imagem);
            } catch (IOException e) {
                logger.error("Erro ao carregar a imagem produto1.jpg: " + e.getMessage());
            }

            // ****************************************************************
            path = Paths.get("c:/temp/produto2.jpg");
            try (InputStream file = Files.newInputStream(path)) {
                byte[] arquivo2 = file.readAllBytes();
                Imagem imagem = new Imagem();
                imagem.setId(2L); // associa o id do produto ao id da imagem
                imagem.setNome("produto2.jpg");
                imagem.setCaminho("imagens/" + imagem.getNome());
                imagem.setArquivo(arquivo2);
                logger.info(">>>>> loaddatabase -> upload de arquivo imagem realizado => " + arquivo2.length);
                imagemRepository.save(imagem);
            } catch (IOException e) {
                logger.error("Erro ao carregar a imagem produto2.jpg: " + e.getMessage());
            }
            // ****************************************************************
            path = Paths.get("c:/temp/produto3.jpg");
            try (InputStream file = Files.newInputStream(path)) {
                byte[] arquivo3 = file.readAllBytes();
                Imagem imagem = new Imagem();
                imagem.setId(3L); // associa o id do produto ao id da imagem
                imagem.setNome("produto3.jpg");
                imagem.setCaminho("imagens/" + imagem.getNome());
                imagem.setArquivo(arquivo3);
                logger.info(">>>>> loaddatabase -> upload de arquivo imagem realizado => " + arquivo3.length);
                imagemRepository.save(imagem);
            } catch (IOException e) {
                logger.error("Erro ao carregar a imagem produto3.jpg: " + e.getMessage());
            }
        };
    }
}
