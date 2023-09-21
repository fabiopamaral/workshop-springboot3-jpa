package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    //A interface não necessita implementação dos métodos, pois já implementado
    //no tipo Generics JpaRepository
    //UserRepository já herda a anotação @Component do JpaRepository.
}
