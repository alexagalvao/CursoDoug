package io.github.alexagalvao.rest.controller;

import io.github.alexagalvao.domain.entity.Pedido;
import io.github.alexagalvao.dto.PedidoDTO;
import io.github.alexagalvao.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {



    private PedidoService service;

    public PedidoController (PedidoService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }


}
