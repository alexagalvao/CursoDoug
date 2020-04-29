package io.github.alexagalvao.domain.repository;

import io.github.alexagalvao.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidos extends JpaRepository<ItemPedido, Integer> {
}
