package com.fatec.produto.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fatec.produto.model.IimagemRepository;
import com.fatec.produto.model.Imagem;
import com.fatec.produto.model.IprodutoRepository;
import com.fatec.produto.model.Produto;

@Service
public class ImagemService implements IimagemService {

    private static final Logger logger = LogManager.getLogger(ImagemService.class);

    @Autowired
    private IimagemRepository imagemRepository;

    @Autowired
    private IprodutoRepository produtoRepository;

    @Override
    public List<Imagem> getAll() {
        // Retorne uma lista de imagens
        return imagemRepository.findAll();
    }

    @Override
    public Optional<Imagem> salvar(MultipartFile arquivo, long id) throws IOException {
        logger.info(">>>>>> servico salvar imagem - iniciado...");
        Optional<Produto> p = produtoRepository.findById(id);

        if (p.isPresent()) {
            logger.info(">>>>>> servico salvar imagem - produto encontrado");
            String nome = arquivo.getOriginalFilename();
            Path caminhoArquivo = Paths.get("imagens/" + nome);
            logger.info(">>>>>> servico salvar imagem - caminho arquivo => " + caminhoArquivo);

            Imagem imagem = new Imagem();
            imagem.setId(id); // associa o id do produto ao id da imagem
            imagem.setNome(arquivo.getOriginalFilename());
            imagem.setCaminho(caminhoArquivo.toString());
            imagem.setArquivo(arquivo.getBytes());
            logger.info(">>>>>> servico salvar imagem - arquivo getSize => " + arquivo.getSize());

            return Optional.of(imagemRepository.save(imagem));
        } else {
            logger.info(">>>>>> servico salvar imagem - id nao encontrado");
            return Optional.empty();
        }
    }

    @Override
    public byte[] getImagem(String nomeArquivo) {
        Optional<Imagem> dbImagem = imagemRepository.findByNome(nomeArquivo);
        if (dbImagem.isPresent())
            return dbImagem.get().getArquivo();
        else
            return new byte[0];
    }

    @Override
    public byte[] getImagemById(Long id) {
        Optional<Imagem> dbImagem = imagemRepository.findById(id);
        if (dbImagem.isPresent())
            return dbImagem.get().getArquivo();
        else
            return new byte[0];
    }

    @Override
    public Imagem getImagemByProdutoId(Long produtoId) {
        Optional<Produto> produtoOptional = produtoRepository.findById(produtoId);

        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            return imagemRepository.findById(produto.getId()).orElse(null);
        }

        return null;
    }
}
