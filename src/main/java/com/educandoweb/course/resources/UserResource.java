package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

//Classes anotadas como @Controller geralmente são usadas para criar controladores
//que lidam com solicitações web, mas elas retornam principalmente representações de visualização
//Classe anotadas como @RestController são usadas para criar controladores RESTful que
//lidam com solicitações HTTP, que retornam dados serializados no formato JSON ou XML
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "99999", "12345");
        return ResponseEntity.ok().body(u);
    }

}
