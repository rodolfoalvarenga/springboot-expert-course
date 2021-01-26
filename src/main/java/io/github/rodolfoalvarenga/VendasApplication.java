package io.github.rodolfoalvarenga;

import io.github.rodolfoalvarenga.domain.entity.Cliente;
import io.github.rodolfoalvarenga.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Rodolfo"));
            clientes.save(new Cliente("Thaís"));

            boolean existe = clientes.existsByNome("Rodolfo");
            System.out.println("Existe um cliente com o nome Rodolfo? " + existe);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
