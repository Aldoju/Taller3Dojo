package com.trabfinal.dojo.models.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class EventoSenseiId {
    private Long idEvento;
    private Long idSensei;   
    private static final long serialVersionUID=400L;
    public Long getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }
    public Long getIdSensei() {
        return idSensei;
    }
    public void setIdSensei(Long idSensei) {
        this.idSensei = idSensei;
    }

    public EventoSenseiId(){

    }

    public EventoSenseiId(Long idEvento, Long idSensei){
        this.idEvento=idEvento;
        this.idSensei=idSensei;
    }

    

}
