package io.github.rodolfoalvarenga.rest.dto;

import java.math.BigDecimal;
import java.util.List;

/*
{
    "cliente": 1,
    "total": 100,
    "itens": [
        {
            "produto": 1,
            "quantidade": 10
        }
    ]
}
 */
public class PedidoDTO {

    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> itens;
}
