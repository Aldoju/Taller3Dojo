package com.trabfinal.dojo.models.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class AlumnoEventoId {
    private Long idAlumno;
    private Long idEvento;   
    private static final long serialVersionUID=400L;
    public Long getIdAlumno() {
        return idAlumno;
    }
    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }
    public Long getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public AlumnoEventoId(){

    }

    public AlumnoEventoId(Long idAlumno,Long idEvento){
        this.idAlumno=idAlumno;
        this.idEvento=idEvento;
    }
}


