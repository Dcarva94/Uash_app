package com.uash.uash.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="lavagem")
@Setter
@Getter

public class Lavagem {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private int id;
    private int valor;
    private enum tipoLavagem;
    private String localizacao;    
}