package com.example.berg.doublety;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Berg on 28/03/16.
 */
public class CadastroUsuarioFragment extends DialogFragment {

    private EditText nomeUsuario;

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle("Cadastro");
        //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_cadastro, container, false);



        Button confirmar = (Button) view.findViewById(R.id.btn);


        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nomeUsuario = (EditText)view.findViewById(R.id.usuario);
                String texto = nomeUsuario.getText().toString();
                if (TextUtils.isEmpty(texto)) {
                    nomeUsuario.setError("Campo vazio!");
                    nomeUsuario.requestFocus();
                }else {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nome", texto);
                    intent.putExtras(bundle);
                    dismiss();
                    Toast.makeText(getActivity(),"Bem vindo " + texto+"!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }



    /*

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_cadastro, null);
        builder.setView(view);

        builder.setTitle("Cadastro");

        nomeUsuario = (EditText) view.findViewById(R.id.usuario);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (TextUtils.isEmpty(nomeUsuario.getText().toString())) {
                    nomeUsuario.setError("Por favor digite seu nome!");
                    nomeUsuario.requestFocus();
                    Toast.makeText(getActivity(), "Campo vazio",
                            Toast.LENGTH_SHORT).show();

                }
                //if (nomeUsuario.getText().toString().equals("")) {
                // Toast.makeText(getActivity(), "Campo vazio",
                //           Toast.LENGTH_SHORT).show();
                // }
                else {
                    Toast.makeText(getActivity(), "Cadastro confirmado",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });


        return builder.create();
    }*/


}
