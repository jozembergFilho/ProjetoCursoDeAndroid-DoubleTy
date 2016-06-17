package com.example.berg.doublety;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.berg.doublety.entidades.Pergunta;
import com.example.berg.doublety.fragments.Fragment01;

import java.util.ArrayList;

public class PraticarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button btn_sequencial;
    private Button btn_condicional;
    private Button btn_repeticao;
    private ImageView imageView;

    private DoubleTyApplication application;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praticar);

        application = (DoubleTyApplication) getApplicationContext();

        toolbar = (Toolbar)findViewById(R.id.toolbarManual);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_sequencial = (Button)findViewById(R.id.btn_praticar1);
        btn_condicional = (Button)findViewById(R.id.btn_praticar2);
        btn_repeticao = (Button)findViewById(R.id.btn_praticar3);

        btn_sequencial.setOnClickListener(new ClickListener("Sequencial"));
        btn_condicional.setOnClickListener(new ClickListener("Condicional"));
        btn_repeticao.setOnClickListener(new ClickListener("Repetição"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            //finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ClickListener implements View.OnClickListener{

        private String TAG;

        private ClickListener(String TAG){
            this.TAG = TAG;
        }
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(PraticarActivity.this, AtividadesActivity.class);
            Pergunta pergunta = application.carregarPerguntaAteatoriaTipo(TAG);
            intent.putExtra("TAG", TAG);
            intent.putExtra("idPergunta", pergunta.getId());
            if(application.getMaxQuestion() < 3){
                application.setMaxQuestion(3);
            }
            application.setIdQuestionEscolhidas(new ArrayList<Long>());
            startActivity(intent);
            PraticarActivity.this.finish();
        }
    }


}
