package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

//Classes anotadas como @Controller geralmente são usadas para criar controladores
//que lidam com solicitações web, mas elas retornam principalmente representações de visualização
//Classe anotadas como @RestController são usadas para criar controladores RESTful que
//lidam com solicitações HTTP, que retornam dados serializados no formato JSON ou XML
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired
    private UserService service;

    @GetMapping // recuperar dados do banco
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) { //@PathVariable faz o id ser reconhecido como uma variavel na URL
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping //inserir recursos no banco de dados
    public ResponseEntity<User> insert(@RequestBody User obj) {
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand((obj.getId())).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}") //Atualizar
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
