package com.trabfinal.dojo.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name="GradoClase")
public class GradoClase {

    @EmbeddedId
    public GradoClaseId id;

    @ManyToOne
    @MapsId("idGrado")
	@JoinColumn(name = "idGrado")
	private Grado grado;

    @ManyToOne
    @MapsId("idClase")
	@JoinColumn(name = "idClase")
	private Clase clase;



    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public GradoClaseId getId() {
        return id;
    }

    public void setId(GradoClaseId id) {
        this.id = id;
    }


    
}
