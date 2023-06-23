package com.trabfinal.dojo.models.entity;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="Sensei")
public class Sensei implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "idSensei")
    private Long idSensei;

    @NotNull
    private String nombres,apellidos,direccion,numeroCelular;
    
    @Email
    private String email;
    
    @NotNull
    private int edad;

    @NotNull
    private double peso,altura;


    @OneToMany(mappedBy = "sensei",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Horario> horario;

    @ManyToOne(fetch = FetchType.LAZY)
	private Clase clase;

    //relacion de muchos a muchos con evento
    //relacion de uno a muchos con evento-profesor

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idSensei")
	private List<EventoSensei> items;



    public List<Horario> getHorarios() {
        return horario;
    }

    public void setHorarios(List<Horario> horario) {
        this.horario = horario;
    }
    
    public Long getIdSensei() {
        return idSensei;
    }

    public void setIdSensei(Long idSensei) {
        this.idSensei = idSensei;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public List<Horario> getHorario() {
        return horario;
    }

    public void setHorario(List<Horario> horario) {
        this.horario = horario;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public List<EventoSensei> getItems() {
        return items;
    }

    public void setItems(List<EventoSensei> items) {
        this.items = items;
    }
    
}
