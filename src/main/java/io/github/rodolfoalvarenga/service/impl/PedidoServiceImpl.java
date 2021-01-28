package io.github.rodolfoalvarenga.service.impl;

import io.github.rodolfoalvarenga.domain.entity.Cliente;
import io.github.rodolfoalvarenga.domain.entity.ItemPedido;
import io.github.rodolfoalvarenga.domain.entity.Pedido;
import io.github.rodolfoalvarenga.domain.entity.Produto;
import io.github.rodolfoalvarenga.domain.repository.Clientes;
import io.github.rodolfoalvarenga.domain.repository.ItensPedido;
import io.github.rodolfoalvarenga.domain.repository.Pedidos;
import io.github.rodolfoalvarenga.domain.repository.Produtos;
import io.github.rodolfoalvarenga.exception.RegraNegocioException;
import io.github.rodolfoalvarenga.rest.dto.ItemPedidoDTO;
import io.github.rodolfoalvarenga.rest.dto.PedidoDTO;
import io.github.rodolfoalvarenga.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private Pedidos repository;

    @Autowired
    private Clientes clientesRepository;

    @Autowired
    private Produtos produtosRepository;

    @Autowired
    private ItensPedido itensPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository.findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido"));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedido = converterItens(pedido, dto.getItens());
        repository.save(pedido);
        itensPedidoRepository.saveAll(itensPedido);
        pedido.setItens(itensPedido);

        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> itens) {
        if (itens.isEmpty()) {
            throw new RegraNegocioException("Não é possível realizar um pedido sem itens.");
        }

        return itens
                .stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () -> new RegraNegocioException(
                                            "Código de produto inválido: " + idProduto
                                    )
                            );

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }
}
