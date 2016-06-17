package com.example.berg.doublety;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.berg.doublety.entidades.Pergunta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class AtividadesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DoubleTyApplication doubleTyApplication;
    private TextView textView;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button button;
    private Pergunta pergunta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividades);

        doubleTyApplication = (DoubleTyApplication)getApplicationContext();

        final String TAG = getIntent().getExtras().getString("TAG");
        final long id = getIntent().getExtras().getLong("idPergunta");
        final Pergunta pergunta = doubleTyApplication.buscarPerguntaId(id);

        toolbar = (Toolbar)findViewById(R.id.toolbar_atividades);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(TAG);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        textView = (TextView) findViewById(R.id.textview_questoes);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        button = (Button)findViewById(R.id.btn_confirmarQuestao);

        button.setBackground(getResources().getDrawable(R.drawable.raised_button_disable));
        button.setEnabled(false);

        final String[] escolha = {""};

        Random random = new Random();
        if(pergunta != null) {
            textView.setText(pergunta.getTexto());
            radioButton1.setText(pergunta.getAlternativas().get(0).getTexto());
            radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        button.setBackground(getResources().getDrawable(R.drawable.raised_button_red));
                        button.setEnabled(true);
                        radioButton2.setChecked(false);
                        radioButton3.setChecked(false);
                        radioButton4.setChecked(false);
                        escolha[0] = radioButton1.getText().toString();
                    }
                }
            });
            radioButton2.setText(pergunta.getAlternativas().get(1).getTexto());
            radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        button.setBackground(getResources().getDrawable(R.drawable.raised_button_red));
                        button.setEnabled(true);
                        radioButton1.setChecked(false);
                        radioButton3.setChecked(false);
                        radioButton4.setChecked(false);
                        escolha[0] = radioButton2.getText().toString();
                    }
                }
            });
            radioButton3.setText(pergunta.getAlternativas().get(2).getTexto());
            radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        button.setBackground(getResources().getDrawable(R.drawable.raised_button_red));
                        button.setEnabled(true);
                        radioButton1.setChecked(false);
                        radioButton2.setChecked(false);
                        radioButton4.setChecked(false);
                        escolha[0] = radioButton3.getText().toString();

                    }
                }
            });
            radioButton4.setText(pergunta.getAlternativas().get(3).getTexto());
            radioButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        button.setBackground(getResources().getDrawable(R.drawable.raised_button_red));
                        button.setEnabled(true);
                        radioButton1.setChecked(false);
                        radioButton2.setChecked(false);
                        radioButton3.setChecked(false);
                        escolha[0] = radioButton4.getText().toString();
                    }
                }
            });
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(escolha[0].equalsIgnoreCase(pergunta.getRespostaCorreta().getTexto())){
                    new AlertDialog.Builder(AtividadesActivity.this)
                            .setTitle("Resposta correta!")
                            .setMessage("Vamos para próxima pergunta.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Log.i("v", ""+doubleTyApplication.getMaxQuestion());
                                    if(doubleTyApplication.getMaxQuestion() > 1){
                                        doubleTyApplication.menosUm();
                                        Intent intent = new Intent(AtividadesActivity.this, AtividadesActivity.class);
                                        Pergunta p2 = doubleTyApplication.carregarPerguntaAteatoriaTipo(TAG);
                                        intent.putExtra("TAG", TAG);
                                        intent.putExtra("idPergunta", p2.getId());
                                        startActivity(intent);
                                    }else{
                                        startActivity(new Intent(AtividadesActivity.this, PraticarActivity.class));
                                        finish();
                                    }
                                    finish();
                                }
                            }).create().show();
                    //Toast.makeText(AtividadesActivity.this, "Acertou", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(v,"Acertou!",Snackbar.LENGTH_SHORT).show();



                }else if(!escolha[0].equalsIgnoreCase(pergunta.getRespostaCorreta().getTexto())){

                    new AlertDialog.Builder(AtividadesActivity.this)
                            .setTitle("Resposta errada!")
                            .setMessage("Vamos para próxima pergunta.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Log.i("v", ""+doubleTyApplication.getMaxQuestion());
                                    if(doubleTyApplication.getMaxQuestion() > 1){
                                        doubleTyApplication.menosUm();
                                        Intent intent = new Intent(AtividadesActivity.this, AtividadesActivity.class);
                                        Pergunta p2 = doubleTyApplication.carregarPerguntaAteatoriaTipo(TAG);
                                        intent.putExtra("TAG", TAG);
                                        intent.putExtra("idPergunta", p2.getId());
                                        startActivity(intent);
                                    }else{
                                        startActivity(new Intent(AtividadesActivity.this, PraticarActivity.class));
                                        finish();
                                    }
                                    finish();
                                }
                            }).create().show();

                }else{


                    //Toast.makeText(AtividadesActivity.this, "Errou", Toast.LENGTH_SHORT).show();
                    Snackbar.make(v,"Marque alguma alternativa!",Snackbar.LENGTH_SHORT).show();

                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            new AlertDialog.Builder(this)
                    .setTitle("Tem certeza que deseja sair?")
                    .setMessage("Todo o progresso nesta sessão será perdido.")
                    .setPositiveButton("Desistir", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(AtividadesActivity.this, PraticarActivity.class));
                            finish();
                        }
                    })
                    .setNegativeButton("Cancelar", null)
                    .create().show();
        }
        return super.onOptionsItemSelected(item);

    }

}
