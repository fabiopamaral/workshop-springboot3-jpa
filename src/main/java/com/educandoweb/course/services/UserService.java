package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//@Component Registra a classe como componente do Spring, podendo ser automaticamente injetado pelo @Autowired
@Service //Igual ao @Component, porém mais especifico
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll(); //Serviço manda o Repositório buscar os dados
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
}