package io.github.rodolfoalvarenga.service.impl;

import io.github.rodolfoalvarenga.domain.repository.Pedidos;
import io.github.rodolfoalvarenga.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private Pedidos repository;
}
