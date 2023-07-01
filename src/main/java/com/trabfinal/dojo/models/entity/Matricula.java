package com.trabfinal.dojo.models.entity;
import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Matricula")
public class Matricula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatricula;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSensei")
    private Sensei sensei;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idClase")
    private Clase clase;

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Sensei getSensei() {
        return sensei;
    }

    public void setSensei(Sensei sensei) {
        this.sensei = sensei;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }



}
