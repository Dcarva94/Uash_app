package com.uash.uash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.uash.uash.model.User;
import com.uash.uash.repository.UserRepository;



@RestController
public class UserController {
        @Autowired
    private UserRepository userRepo;
       
    @GetMapping("/users")
    public List<User> listAll() {
        return userRepo.findAll();
    }
    @GetMapping("/users/{id}")
    public User one(@PathVariable Integer id) { 
        return userRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/users")
    public User newUser(@RequestBody User newUsers) {
        return userRepo.save(newUsers);
    }

    @PutMapping("/users/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Integer id ) {
    
    return userRepo.findById(id)
      .map(user -> {
        user.setNome(newUser.getNome());
        user.setPassword(newUser.getPassword());
        user.setTelefone(newUser.getTelefone());
        user.setLocalizacao(newUser.getLocalizacao());
        return userRepo.save(user);
      })
      .orElseGet(() -> {
        newUser.setId(id);
        return userRepo.save(newUser);
      });
  }

  @DeleteMapping("/users/{id}")
  void deleteUser(@PathVariable Integer id) {
    userRepo.deleteById(id);
  }
}
