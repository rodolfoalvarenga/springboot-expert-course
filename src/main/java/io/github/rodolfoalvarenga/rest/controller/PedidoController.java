package io.github.rodolfoalvarenga.rest.controller;

import io.github.rodolfoalvarenga.domain.entity.Pedido;
import io.github.rodolfoalvarenga.rest.dto.PedidoDTO;
import io.github.rodolfoalvarenga.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO dto) {
        // retorna o pedido salvo/realizado
        Pedido pedido = service.salvar(dto);
        // retorna o Id deste novo pedido
        return pedido.getId();
    }
}
