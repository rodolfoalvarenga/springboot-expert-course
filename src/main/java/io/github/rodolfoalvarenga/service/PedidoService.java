package io.github.rodolfoalvarenga.service;

import io.github.rodolfoalvarenga.domain.entity.Pedido;
import io.github.rodolfoalvarenga.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);
}
