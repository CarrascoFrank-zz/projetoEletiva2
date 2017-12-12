package com.example.frankgalvez.appcurriculo;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InfoPessoaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pessoais);

        SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

        //TABELA
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS dadospessoais(nome varchar, idade INT(3) ) ");


    }
}
