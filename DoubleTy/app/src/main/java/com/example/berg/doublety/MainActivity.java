package com.example.berg.doublety;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
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
    private View btnSair, btnPraticar, btnManual;
    private ImageView btnSobre;
    private ImageView btnRanking;
    private ImageView btnSettings;

    private DoubleTyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        application = (DoubleTyApplication) getApplicationContext();

        if(application.isDialog()){
            exbirAlertaDialog();
        }
        //exemplo_layout();
        btnSair = findViewById(R.id.btn_sair);
        btnPraticar = findViewById(R.id.btn_praticar);
        btnManual = findViewById(R.id.btn_exercicios);
        btnSobre = (ImageView)findViewById(R.id.img_sobre);
        btnRanking = (ImageView)findViewById(R.id.img_ranking);
        btnSettings = (ImageView)findViewById(R.id.img_settings);

        btnPraticar.setOnClickListener(new ClickListener(this,PraticarActivity.class));
        btnManual.setOnClickListener(new ClickListener(this,ManualActivity.class));
        btnSair.setOnClickListener(new ClickListener(this,null));
        btnSobre.setOnClickListener(new ClickListener(this,SobreActivity.class));
        btnRanking.setOnClickListener(new ClickListener(this,RankingActivity.class));
        btnSettings.setOnClickListener(new ClickListener(this, SettingsActivity.class));


    }
    private void exbirAlertaDialog(){
        DialogFragment usuario = new CadastroUsuarioFragment();
        usuario.show(getFragmentManager(),"usuario");
    }
    private class ClickListener implements View.OnClickListener{
        private Class aClass;
        private Context context;

        public Context getContext(){
            return this.context;
        }
        private ClickListener(Context context, Class aClass){
            this.context = context;
            this.aClass = aClass;
        }
        @Override
        public void onClick(View v) {
            if(aClass == null){
                MainActivity.this.finish();
            }
            else{
                application.setDialog(false);
                Intent intent = new Intent(getContext(),aClass);
                startActivity(intent);
                MainActivity.this.finish();
            }


        }
    }

}
