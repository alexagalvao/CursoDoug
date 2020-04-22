package io.github.alexagalvao.service;

import io.github.alexagalvao.model.Cliente;
import io.github.alexagalvao.repository.ClientesRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository repository;

    public  ClientesService (ClientesRepository repository){
        this.repository = repository;
    }

      public void salvarCliente (Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
      }

    private void validarCliente(Cliente cliente) {
    }
}
