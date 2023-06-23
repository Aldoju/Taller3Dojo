package com.trabfinal.dojo.models.entity;

import java.io.Serializable;
// import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

// import org.springframework.format.annotation.DateTimeFormat;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
//mport jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
// import jakarta.persistence.Temporal;
// import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
 
@Entity
@Table(name = "alumnos")
public class Alumno  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAlumno")
	private Long id;
    
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    private String edad;
    @NotEmpty
    private String direccion;
    @NotEmpty
    private String celular;
    @NotEmpty
    private String peso;
    @NotEmpty
    private String altura;

	@ManyToOne
	private Clase clase;


	@ManyToMany
    @JoinTable(
        name="AlumnoEvento",
        joinColumns = @JoinColumn( name="idAlumno"),
        inverseJoinColumns = @JoinColumn(name="idEvento")
    )
	private List<Evento> eventos;


	public Clase getClase(){
		return clase;
	}
	public void setClase(Clase clase){
		this.clase = clase;
	}

    
    private static  final long serialVersionUID=1L;
    
    public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
    
    
	
}
