package com.uash.uash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uash.uash.model.Uasher;
import com.uash.uash.repository.UasherRepository;

@RestController
public class UasherController {
    @Autowired
    private UasherRepository uasherRepo;
       
    @GetMapping("/uashers")
    public List<Uasher> listAll() {
        return uasherRepo.findAll();
    }

    @GetMapping("/uashers/{id}")
    public Uasher one(@PathVariable Integer id) { 
        return uasherRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @PostMapping("/uashers")
    public Uasher newUashers(@RequestBody Uasher newUasheres) {
        return uasherRepo.save(newUasheres);
  }
    @PutMapping("/uashers/{id}")
    public Uasher replaceUasher(@RequestBody Uasher newUasher, @PathVariable Integer id ) {
    
    return uasherRepo.findById(id)
      .map(uasher -> {
        uasher.setRating(newUasher.getRating());
        uasher.setLocalizacao(newUasher.getLocalizacao());
        uasher.setCartaConducao(newUasher.getCartaConducao());
        uasher.setMaterial(newUasher.isMaterial());
        return uasherRepo.save(uasher);
      })
      .orElseGet(() -> {
        newUasher.setId(id);
        return uasherRepo.save(newUasher);
      });
  }

  @DeleteMapping("/Uashers/{id}")
  void deleteUasher(@PathVariable Integer id) {
    uasherRepo.deleteById(id);
  }

}
