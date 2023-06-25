package com.trabfinal.dojo.models.entity;



import jakarta.persistence.*;

@Embeddable
public class GradoClaseId {
    private Long idGrado;
    private Long idClase;   
    private static final long serialVersionUID=400L;
    
    public Long getIdGrado() {
        return idGrado;
    }
    public void setIdGrado(Long idGrado) {
        this.idGrado = idGrado;
    }
    public Long getIdClase() {
        return idClase;
    }
    public void setIdClase(Long idClase) {
        this.idClase = idClase;
    }

    public GradoClaseId(){

    }

    public GradoClaseId(Long idGrado,Long idClase){
        this.idClase=idClase;
        this.idGrado=idGrado;
    }

}
