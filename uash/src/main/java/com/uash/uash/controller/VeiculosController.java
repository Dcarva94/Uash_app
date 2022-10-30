package com.uash.uash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}