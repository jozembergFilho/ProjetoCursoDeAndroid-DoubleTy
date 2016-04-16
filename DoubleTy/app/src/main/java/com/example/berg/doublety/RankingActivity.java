package com.example.berg.doublety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RankingActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView rankingJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        rankingJogador = (TextView)findViewById(R.id.rankingJogador);
        toolbar = (Toolbar)findViewById(R.id.toolbarRanking);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ranking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Bundle args = getIntent().getExtras();
        //String nome = args.getString("nome");
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
