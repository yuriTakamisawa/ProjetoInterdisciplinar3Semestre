package com.fatec.produto.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fatec.produto.service.IclienteService;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    IclienteService clienteService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Object> consultaTodos() {
        logger.info(">>>>>> apicontroller consulta todos clientes");
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.visualizarClientes());
    }

}
