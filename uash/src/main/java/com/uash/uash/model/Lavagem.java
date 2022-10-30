// Model é a entidade do banco


package com.uash.uash.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uash.uash.enumerado.Status;
import com.uash.uash.enumerado.TipoLavagemEnum;
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
    private TipoLavagemEnum tipoLavagem;
    private String localizacao;   
    private LocalDateTime horario;
    private Status status;
    
}