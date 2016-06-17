package com.example.berg.doublety.entidades;

import com.example.berg.doublety.entidades.Resposta;

import java.io.Serializable;
import java.util.List;

public class Pergunta implements Serializable{

    private long id;
    private String texto;
    private List<Resposta> alternativas;
    private String tipo;

    public Pergunta() {
    }

    public Pergunta(String texto, List<Resposta> alternativas, String tipo) {
        this.texto = texto;
        this.alternativas = alternativas;
        this.tipo = tipo;
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

    public List<Resposta> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Resposta> alternativas) {
        this.alternativas = alternativas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Resposta getRespostaCorreta(){
        Resposta resposta = null;
        for (Resposta r :alternativas){
            if(r.isStatus()){
                resposta = r;
            }
        }
        return resposta;

    }

}
