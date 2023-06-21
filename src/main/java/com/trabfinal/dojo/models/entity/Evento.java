package com.trabfinal.dojo.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.Temporal;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "eventos" )
public class Evento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvento")
	private Long id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String lugar;
    
    @NotEmpty
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
	private Clase clase;

	

	public Clase getClase(){
		return clase;
	}
	public void setClase(Clase clase){
		this.clase = clase;
	}


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
    public String getLugar() {
		return nombre;
	}
	public void setLugar(String nombre) {
		this.nombre = nombre;
	}
    public Date getFecha(){
        return fecha;
    }
    public void setFecha( Date fecha){
        this.fecha=fecha;
    }

}
