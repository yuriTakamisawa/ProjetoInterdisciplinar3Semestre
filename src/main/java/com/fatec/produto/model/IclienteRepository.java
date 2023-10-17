package com.fatec.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.produto.model.Cliente;

@Repository
public interface IclienteRepository extends JpaRepository<Cliente, Long> {
    public Cliente findAllByEmail(String email);

}
