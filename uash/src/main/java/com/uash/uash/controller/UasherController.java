package com.uash.uash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uash.uash.model.Uasher;
import com.uash.uash.repository.UasherRepository;

@RestController
public class UasherController {
    @Autowired
    private UasherRepository uasherRepo;
       
    @GetMapping("/uasheres")
    public List<Uasher> listAll() {
        return uasherRepo.findAll();
    }
}
