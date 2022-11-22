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

import com.uash.uash.model.Veiculo;
import com.uash.uash.repository.VeiculoRepository;

@RestController
public class VeiculosController {
    @Autowired
    private VeiculoRepository veiculoRepo;
       
    @GetMapping("/veiculos")
    public List<Veiculo> listAll() {
        return veiculoRepo.findAll();
    }
    @GetMapping("/veiculos/{id}")
    public Veiculo one(@PathVariable Integer id) { 
        return veiculoRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @PostMapping("/veiculos")
    public Veiculo newVeiculo(@RequestBody Veiculo newVeiculo) {
        return veiculoRepo.save(newVeiculo);
    }

    @PutMapping("/veiculos/{id}")
    public Veiculo replaceVeiculo(@RequestBody Veiculo newVeiculo, @PathVariable Integer id ) {
    
    return veiculoRepo.findById(id)
      .map(veiculo -> {
        veiculo.setTipo(newVeiculo.getTipo());
        veiculo.setMatricula(newVeiculo.getMatricula());
        veiculo.setLocalizacao(newVeiculo.getLocalizacao());
        return veiculoRepo.save(veiculo);
      })
      .orElseGet(() -> {
        newVeiculo.setId(id);
        return veiculoRepo.save(newVeiculo);
      });
  }

  @DeleteMapping("/veiculos/{id}")
  void deleteVeiculo(@PathVariable Integer id) {
    veiculoRepo.deleteById(id);
  }
}