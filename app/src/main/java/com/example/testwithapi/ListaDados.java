package com.example.testwithapi;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class ListaDados extends AppCompatActivity {

    private SQLiteDatabase bancoDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dados);

        criarBancoDados();
        listaDados();
    }

    //método de criação de banco de dados
    public void criarBancoDados(){

        try {
            bancoDados = openOrCreateDatabase("crud", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS PESSOA("+
                            "  ID INTEGER PRIMARY  KEY AUTOINCREMENT" +
                            ", nome VARCHAR" +
                            ", SOBRENOME VARCHAR) ");
            bancoDados.close();
        }catch (Exception e){

            e.printStackTrace();
        }
    }
    public void listaDados(){

    }


}