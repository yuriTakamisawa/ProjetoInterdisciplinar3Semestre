package com.fatec.produto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.produto.model.Imagem;

@Repository
public interface IimagemRepository extends JpaRepository<Imagem, Long> {
    Optional<Imagem> findByNome(String nome);
}
