package com.example.berg.doublety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        editText = (EditText) findViewById(R.id.usuario);
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
            editText.setError("Campo vazio!");
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
