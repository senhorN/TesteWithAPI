package com.example.testwithapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.BreakIterator;

import Connection.ConexaoAPI;

public class MainActivity extends AppCompatActivity {
    //Realizando testes
    private Button btn, btnConselho, btnComida, btnLista;
    private TextView txt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        txt = (TextView) findViewById(R.id.txt);
        btnConselho = (Button) findViewById(R.id.btnConselho);
        btnComida = (Button) findViewById(R.id.btnComida);
        btnLista = (Button) findViewById(R.id.btnLista);

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Lista();}
        });
        btnComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comida();
            }
        });
        btnConselho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Conselho();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Tarefa tarefa = new Tarefa();
                tarefa.execute("https://viacep.com.br/ws/01001000/json/");

            }
        });
    }

    private class Tarefa extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            String retorno = ConexaoAPI.getDados(strings[0]);

            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {

            txt.setText(s);
        }
    }

    /*metodo Conselho e Gato*/
    private void Conselho()
    {
        Intent intent = new Intent(this, Conselho.class);
        startActivity(intent);
    }

    private void Comida()
    {
        Intent intent = new Intent(this, Food.class);
        startActivity(intent);
    }

    private void Lista(){
        Intent intent = new Intent(this, ListaDados.class);
        startActivity(intent);
    }

}
