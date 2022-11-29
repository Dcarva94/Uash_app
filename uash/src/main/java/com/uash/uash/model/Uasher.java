package com.uash.uash.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.uash.uash.enumerado.RatingOpcao;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="uasher")
@Setter
@Getter

public class Uasher {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private int id;
    private RatingOpcao rating;
    private String cartaConducao;
    private boolean material;
    private String localizacao;
    @OneToOne( targetEntity=User.class )
    private User user;  
}