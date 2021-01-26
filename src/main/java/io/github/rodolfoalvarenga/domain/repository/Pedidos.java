package io.github.rodolfoalvarenga.domain.repository;

import io.github.rodolfoalvarenga.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
