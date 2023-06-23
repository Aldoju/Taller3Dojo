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


//tabla intermedia
@Entity
@Table(name="EventoSensei")
public class EventoSensei implements Serializable {    
    @EmbeddedId
    public EventoSenseiId id;

    @ManyToOne
    @MapsId("idEvento")
	@JoinColumn(name = "idEvento")
	private Evento evento;

    @ManyToOne
    @MapsId("idSensei")
	@JoinColumn(name = "idSensei")
	private Sensei sensei;

    public EventoSenseiId getId() {
        return id;
    }

    public void setId(EventoSenseiId id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Sensei getSensei() {
        return sensei;
    }

    public void setSensei(Sensei sensei) {
        this.sensei = sensei;
    }

}
