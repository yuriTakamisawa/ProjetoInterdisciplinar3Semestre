package com.fatec.produto.service;

import java.io.IOException;
import java.util.Optional;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fatec.produto.model.Imagem;

public interface IimagemService {
    public Optional<Imagem> salvar(MultipartFile arquivo, long id) throws IOException;

    public List<Imagem> getAll();

    public byte[] getImagem(String nomeArquivo);

    public byte[] getImagemById(Long id);

    public Imagem getImagemByProdutoId(Long id);

}