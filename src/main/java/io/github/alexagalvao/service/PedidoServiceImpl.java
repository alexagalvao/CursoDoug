package io.github.alexagalvao.service;

import io.github.alexagalvao.domain.repository.Pedidos;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements  PedidoService{


    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
