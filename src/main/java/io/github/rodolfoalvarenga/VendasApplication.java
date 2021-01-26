package io.github.rodolfoalvarenga;

import io.github.rodolfoalvarenga.domain.entity.Cliente;
import io.github.rodolfoalvarenga.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Rodolfo"));
            clientes.save(new Cliente("Thaís"));

            List<Cliente> result = clientes.encontrarPorNome("Rodolfo");
            result.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
