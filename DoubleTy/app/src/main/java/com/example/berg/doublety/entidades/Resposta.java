package com.example.berg.doublety.entidades;

import java.io.Serializable;

public class Resposta implements Serializable{

    private long id;
    private String texto;
    private boolean status;

    public Resposta() {
    }

    public Resposta(String texto, boolean status) {
        this.texto = texto;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
