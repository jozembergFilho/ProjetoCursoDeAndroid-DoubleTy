package com.example.berg.doublety.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.berg.doublety.DoubleTyApplication;
import com.example.berg.doublety.R;
import com.example.berg.doublety.entidades.Pergunta;
import com.example.berg.doublety.entidades.Resposta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Berg on 06/04/16.
 */
public class Fragment01 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_01, container, false);

        return view;

    }
}
