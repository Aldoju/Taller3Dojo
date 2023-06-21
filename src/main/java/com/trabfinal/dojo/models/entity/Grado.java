package com.trabfinal.dojo.models.entity;

import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="Grado")
public class Grado implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idGrado")
    private Long id;

    @NotEmpty
    private String nombre;

    @OneToOne(mappedBy = "grado")
    private Clase clase;
    
}
