package com.example.berg.doublety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        editText = (EditText) findViewById(R.id.usuario);
        btn = (Button)findViewById(R.id.btn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logar();
            }
        });
    }

    private void logar() {
        String texto = editText.getText().toString();
        if (TextUtils.isEmpty(texto)) {
            editText.setError("Informe seu nome por favor!");
            editText.requestFocus();
        }else {
            Intent intent = new Intent(this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("nome", texto);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }


    }
}
