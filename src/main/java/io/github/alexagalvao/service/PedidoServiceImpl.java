package io.github.alexagalvao.service;

import io.github.alexagalvao.domain.entity.Cliente;
import io.github.alexagalvao.domain.entity.ItemPedido;
import io.github.alexagalvao.domain.entity.Pedido;
import io.github.alexagalvao.domain.entity.Produto;
import io.github.alexagalvao.domain.repository.Clientes;
import io.github.alexagalvao.domain.repository.ItemPedidos;
import io.github.alexagalvao.domain.repository.Pedidos;
import io.github.alexagalvao.domain.repository.Produtos;
import io.github.alexagalvao.dto.ItemPedidoDTO;
import io.github.alexagalvao.dto.PedidoDTO;
import io.github.alexagalvao.exception.RegrasNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements  PedidoService{


    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItemPedidos itemPedidosRepository;



    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
      Integer idCliente = dto.getCliente();
      Cliente cliente = clientesRepository.findById(idCliente).orElseThrow(() ->
                new RegrasNegocioException("Codigo de Cliente Invalido"));


        Pedido pedido =  new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemPedidos = converterItens(pedido, dto.getItens());
        repository.save(pedido);
        itemPedidosRepository.saveAll(itemPedidos);
        pedido.setItens(itemPedidos);


        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> itens){
        if(itens.isEmpty()){
            throw new RegrasNegocioException("não localizado");
        }
        return  itens
                .stream()
                .map(itemPedidoDTO -> {
                  Integer idProduto = itemPedidoDTO.getProduto();
                Produto produto = produtosRepository
                          .findById(idProduto)
                          .orElseThrow(
                                  () -> new RegrasNegocioException("erro cod prod invalçido " +idProduto
                          ));




                 ItemPedido itemPedido = new ItemPedido();
                 itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
                 itemPedido.setPedido(pedido);

                 return itemPedido;
                }).collect(Collectors.toList());
    }

}
