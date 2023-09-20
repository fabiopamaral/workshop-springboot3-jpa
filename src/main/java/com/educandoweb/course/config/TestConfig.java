package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration // Classe específica de configuração
@Profile("test") // Perfil de teste.
// A classe serve para compilar
public class TestConfig implements CommandLineRunner {

    @Autowired // é usada para realizar a injeção
    // de dependência de forma automática em classes gerenciadas pelo Spring,
    // como componentes, serviços, controladores e outros.
    private UserRepository userRepository; // objeto que acessa os dados no banco

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }

}
