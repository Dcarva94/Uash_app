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

import com.uash.uash.model.Lavagem;
import com.uash.uash.repository.LavagemRepository;

@RestController
public class LavagemController {
    @Autowired
    private LavagemRepository lavagemRepo;
       
    @GetMapping("/lavagens")
    public List<Lavagem> listAll() {
        return lavagemRepo.findAll();
    }
    @GetMapping("/lavagens/{id}")
    public Lavagem one(@PathVariable Integer id) { 
        return lavagemRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/lavagens")
    public Lavagem newLavagem(@RequestBody Lavagem newLavagem) {
        return lavagemRepo.save(newLavagem);
  }
    @PutMapping("/lavagens/{id}")
    public Lavagem replaceLavagem(@RequestBody Lavagem newLavagem, @PathVariable Integer id ) {
    
    return lavagemRepo.findById(id)
      .map(lavagem -> {
        lavagem.setStatus(newLavagem.getStatus());
        return lavagemRepo.save(lavagem);
      })
      .orElseGet(() -> {
        newLavagem.setId(id);
        return lavagemRepo.save(newLavagem);
      });
  }

    @DeleteMapping("/lavagens/{id}")
  void deleteLavagem(@PathVariable Integer id) {
    lavagemRepo.deleteById(id);
  }


    
}
