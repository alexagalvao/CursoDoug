package io.github.alexagalvao.domain.repository;

import io.github.alexagalvao.domain.entity.Cliente;
import io.github.alexagalvao.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

}
