package com.example.berg.doublety;

import android.app.Application;

import com.example.berg.doublety.entidades.Pergunta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import database.DBController;

/**
 * Created by Berg on 13/04/16.
 */
public class DoubleTyApplication extends Application {


    private DBController dbController;
    private boolean exibirDialog;

    private List<Pergunta> perguntaSequencial;
    private List<Pergunta> perguntaCondicional;
    private List<Pergunta> perguntaRepeticao;

    private int maxQuestion = 3;

    private List<Long> idQuestionEscolhidas;

    @Override
    public void onCreate() {
        super.onCreate();
        exibirDialog = true;
        dbController = new DBController(getBaseContext());
        carregarPerguntas();
        idQuestionEscolhidas = new ArrayList<>();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public boolean isDialog() {
        return exibirDialog;
    }

    public void setDialog(boolean dialog) {
        this.exibirDialog = dialog;
    }

    public List<Pergunta> getPerguntaTipo(String tipo) {
        return dbController.getPerguntaTipo(tipo);
    }

    public int getMaxQuestion() {
        return maxQuestion;
    }

    public void menosUm(){
        this.maxQuestion -= 1;
    }

    public void setMaxQuestion(int maxQuestion) {
        this.maxQuestion = maxQuestion;
    }

    public void carregarPerguntas() {
        perguntaSequencial = getPerguntaTipo("Sequencial");
        perguntaCondicional = getPerguntaTipo("Condicional");
        perguntaRepeticao = getPerguntaTipo("Repetição");
    }

    public Pergunta buscarPerguntaId(long id){
        return dbController.buscarPerguntaPorId(id);
    }

    public Pergunta carregarPerguntaAteatoriaTipo(String tipo){
        Random random = new Random();

        Pergunta pergunta;

        if(tipo.equalsIgnoreCase("sequencial")){
            int valor = random.nextInt(perguntaSequencial.size() - 1);
            pergunta = perguntaSequencial.get(valor);
            while(idQuestionEscolhidas.contains(pergunta.getId())){
                valor = random.nextInt(perguntaSequencial.size() - 1);
                pergunta = perguntaSequencial.get(valor);
            }
            idQuestionEscolhidas.add(pergunta.getId());
            return pergunta;

        }else if(tipo.equalsIgnoreCase("condicional")){
            int valor = random.nextInt(perguntaCondicional.size() - 1);
            pergunta = perguntaCondicional.get(valor);
            while(idQuestionEscolhidas.contains(pergunta.getId())){
                valor = random.nextInt(perguntaCondicional.size() - 1);
                pergunta = perguntaCondicional.get(valor);
            }
            idQuestionEscolhidas.add(pergunta.getId());
            return pergunta;
        }else{
            int valor = random.nextInt(perguntaRepeticao.size() - 1);
            pergunta = perguntaRepeticao.get(valor);
            while(idQuestionEscolhidas.contains(pergunta.getId())){
                valor = random.nextInt(perguntaRepeticao.size() - 1);
                pergunta = perguntaRepeticao.get(valor);
            }
            idQuestionEscolhidas.add(pergunta.getId());
            return pergunta;
        }
    }

    public void setIdQuestionEscolhidas(List<Long> idQuestionEscolhidas) {
        this.idQuestionEscolhidas = idQuestionEscolhidas;
    }
}
