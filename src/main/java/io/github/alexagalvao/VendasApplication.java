package io.github.alexagalvao;

import io.github.alexagalvao.domain.repositorio.Clientes;
import io.github.alexagalvao.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Value("${application.name}")
    private String  applicationName;

//    @Cachorro
//    private Animal animal;
//
//    @Bean(name = "executarAnimal")
//    public CommandLineRunner executar(){
//        return args -> {
//            this.animal.fazerBarulho();
//        };
//    }

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {

            clientes.salvar(new Cliente("alex"));
            clientes.salvar(new Cliente("outro Cliente"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

//             todosClientes.forEach(c ->{
//                 c.setNome(c.getNome() + " atualizado");
//                 clientes.atualizar(c);
//             });

//          clientes.buscarPorNome("al").forEach(System.out::println);
//
//
//            todosClientes = clientes.obterTodos();
//            todosClientes.forEach(System.out::println);

        };

    }




    @GetMapping("/hello")
    public String helloWorld(){
        return applicationName;
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
