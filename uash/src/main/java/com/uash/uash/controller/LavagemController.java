package com.uash.uash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uash.uash.model.Lavagem;
import com.uash.uash.repository.LavagemRepository;

@RestController
public class LavagemController {
    @Autowired
    private LavagemRepository lavagemRepo;
       
    @GetMapping("/lavagem")
    public List<Lavagem> listAll() {
        List<Lavagem> listLavagem = lavagemRepo.findAll();
           
        return lavagemRepo.findAll();
    }
}
