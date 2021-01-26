package io.github.rodolfoalvarenga.domain.repository;

import io.github.rodolfoalvarenga.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
