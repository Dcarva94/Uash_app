package com.uash.uash.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="usuario")
@Setter
@Getter

public class User {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String password;
    private int telefone;
    private LocalDate dataNasc;
    private String localizacao;
        @OneToMany( targetEntity=Uasher.class )
    private Set uasheres;
    @ManyToMany( targetEntity=Veiculo.class )
    private Set veiculos;
    @OneToOne (targetEntity=Uasher.class )
    private Uasher uasher;
}
