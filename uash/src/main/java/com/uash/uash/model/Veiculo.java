package com.uash.uash.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="veiculo")
@Setter
@Getter

public class Veiculo {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private String localizacao; 
    private String matricula;
    @ManyToMany( targetEntity=User.class )
    private Set users;   
}
    
