package com.trabfinal.dojo.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;


@Entity
@Table(name="Clase")
public class Clase implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClase")
    private Long id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String descripcion;

    @OneToMany(mappedBy = "clase", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Alumno> alumnos;

    @ManyToMany(mappedBy = "clase")
	private List<Grado> grados;

    @OneToMany( mappedBy = "clase", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Evento> eventos;

    @OneToMany(mappedBy = "clase", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Sensei> senseis;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Sensei> getSenseis() {
        return senseis;
    }

    public void setSenseis(List<Sensei> senseis) {
        this.senseis = senseis;
    }


    public List<Grado> getGrados() {
        return grados;
    }

    public void setGrados(List<Grado> grados) {
        this.grados = grados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }        
    
    
}
