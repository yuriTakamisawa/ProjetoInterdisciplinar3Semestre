package com.fatec.produto.service;

import java.util.List;

import com.fatec.produto.model.Cliente;

public interface IclienteService {

    List<Cliente> visualizarClientes();

    Cliente cadastrarCliente(Cliente cliente);

    Cliente alterarCliente(Cliente cliente);

    void deletarCliente(Long id);

}
