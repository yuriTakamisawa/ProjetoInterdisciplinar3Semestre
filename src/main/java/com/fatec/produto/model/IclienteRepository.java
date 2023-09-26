package com.fatec.produto.model;

import org.springframework.data.jpa.repository.JpaRepository;

@repository
public interface IclienteRepository extends JpaRepository<Cliente, Long> {
    public Cliente findAllByEmail(String email);

}
