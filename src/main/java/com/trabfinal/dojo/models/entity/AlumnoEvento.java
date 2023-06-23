package com.trabfinal.dojo.models.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="AlumnoEvento")
public class AlumnoEvento implements Serializable{
    @EmbeddedId
    public AlumnoEventoId id;

    @ManyToOne
    @MapsId("idAlumno")
	@JoinColumn(name = "idAlumno")
	private Alumno alumno;

    @ManyToOne
    @MapsId("idEvento")
	@JoinColumn(name = "idEvento")
	private Evento evento;

    public AlumnoEventoId getId() {
        return id;
    }

    public void setId(AlumnoEventoId id) {
        this.id = id;
    }

    

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    
}
