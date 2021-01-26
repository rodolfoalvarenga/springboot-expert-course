package io.github.rodolfoalvarenga.domain.repository;

import io.github.rodolfoalvarenga.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
