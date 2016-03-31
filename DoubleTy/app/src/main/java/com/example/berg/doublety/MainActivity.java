package com.example.berg.doublety;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.content.DialogInterface.OnShowListener;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    private AlertDialog alerta;
    private View btnSair;
    private View btnPraticar;
    private View btnManual;
    private ImageView ranking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exbirAlertaDialog();

        //exemplo_layout();
        btnSair = findViewById(R.id.btn_sair);
        btnPraticar = findViewById(R.id.btn_praticar);
        btnManual = findViewById(R.id.btn_exercicios);

        btnPraticar.setOnClickListener(new ClickListener(PraticarActivity.class));
        btnManual.setOnClickListener(new ClickListener(ManualActivity.class));
        btnSair.setOnClickListener(new ClickListener(null));



        /*btnSair.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/


        /*final View view = View.inflate(this, R.layout.activity_cadastro, null);

        new AlertDialog.Builder(this).setView(view).setPositiveButton("Cadastrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText = (EditText) view.findViewById(R.id.usuario);
                String texto = editText.getText().toString();
                if(TextUtils.isEmpty(texto)){
                    editText.setError("Campo Vazio");
                    editText.requestFocus();
                }
            }
        }).create().show();*/
    }
    /*private void exemplo_layout() {
        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.activity_cadastro, null);
        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cadastro confirmado", Toast.LENGTH_SHORT).show();
                alerta.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cadastro");
        builder.setView(view);
        alerta = builder.create();
        alerta.show();

    }*/
    private void exbirAlertaDialog(){
        DialogFragment usuario = new CadastroUsuarioFragment();
        usuario.show(getFragmentManager(),"usuario");

    }

    private class ClickListener implements View.OnClickListener{
        private final Class aClass;

        private ClickListener(Class aClass){
            this.aClass = aClass;

        }
        @Override
        public void onClick(View v) {
            if(aClass == null){
                finish();
            }
            else{
                Intent intent = new Intent(getContext(),aClass);
                startActivity(intent);
                finish();
            }


        }
    }
    public Context getContext(){
        return this;
    }






}
