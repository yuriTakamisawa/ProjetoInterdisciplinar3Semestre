package com.fatec.produto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.produto.model.Cliente;
import com.fatec.produto.repository.IclienteRepository;

@Service
public class ClienteService implements IclienteService {

    @Autowired
    private IclienteRepository repository;

    @Override
    public List<Cliente> visualizarClientes() {
        return repository.findAll();
    }

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        String email = cliente.getEmail();

        if (email != null && !email.isEmpty()) {
            Cliente clienteExistente = repository.findAllByEmail(email);
            if (clienteExistente != null) {
                throw new RuntimeException("Já existe um cliente com o mesmo e-mail.");
            }
        } else {
            throw new IllegalArgumentException("O e-mail do cliente não pode estar vazio ou nulo.");
        }

        return repository.save(cliente);
    }

    @Override
    public Cliente alterarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void deletarCliente(Long id) {
        repository.deleteById(id);
    }

}
