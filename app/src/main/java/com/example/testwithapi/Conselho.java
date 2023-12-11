package com.example.testwithapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Connection.ConexaoAPI;

public class Conselho extends AppCompatActivity {
    private Button btn;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conselho);

        btn = (Button) findViewById(R.id.btn);
        txt = (TextView) findViewById(R.id.txt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Tarefa tarefa = new Tarefa();
                tarefa.execute("https://api.adviceslip.com/advice");

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
}




//