package com.hangman.sinapse.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TelaTema extends AppCompatActivity {
    private ListView listTema;
    private Button btJogar;
    private String tema = "";
    private String nivel = "";
    final String[] temas = new String[] {"animais","paises","frutas","esportes","cidades"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_tema);
        listTema = (ListView) findViewById(R.id.listTema);
        carregaTema();
        btJogar = (Button) findViewById(R.id.btJogar);
        findViewById(R.id.rdDificil).setEnabled(false);
        findViewById(R.id.rdSurvive).setEnabled(false);
    }

    public void jogar(View v) {
        switch (v.getId()) {
            case R.id.btJogar:
                Intent i = new Intent(TelaTema.this, GameActivity.class);
                Bundle params = new Bundle();
                params.putString("tema",tema);
                //params.putString("nivel", nivel);
                i.putExtras(params);
                startActivity(i);
                break;
        }
    }

    private void carregaTema(){

        ArrayAdapter<String> itensList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temas);
        listTema.setAdapter(itensList);
        listTema.setOnItemClickListener(clickList());
    }

    public OnItemClickListener clickList() {
        return (new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int position, long id) {
                if(!GameActivity.nivel.equals("")) {
                    tema = temas[position];
                    Intent i = new Intent(TelaTema.this, GameActivity.class);
                    Bundle params = new Bundle();
                    params.putString("tema", tema);
                    //params.putString("nivel", nivel);
                    i.putExtras(params);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Escolha um nível antes de começar!", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    public void onRadioButtonClicked(View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();
        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.rdNormal:
                if (checked){
                    btJogar.setVisibility(View.GONE);
                    listTema.setEnabled(true);
                    GameActivity.nivel = "normal";
                    Toast.makeText(getApplicationContext(),"Esclha o tema ao lado e começe o jogo com tema desejado, não conta para HighScore.", Toast.LENGTH_SHORT).show();
                }
                    break;
            case R.id.rdDificil:
                if (checked){
                    btJogar.setVisibility(View.VISIBLE);
                    listTema.setEnabled(false);
                    GameActivity.nivel = "dificil";
                    Toast.makeText(getApplicationContext(),"Sem tema da palavra sorteada, poderá haver dicas, porém lhe custará um preço. Tema aleatório.", Toast.LENGTH_SHORT).show();
                }
                    break;
            case R.id.rdSurvive:
                if (checked){
                    btJogar.setVisibility(View.VISIBLE);
                    listTema.setEnabled(false);
                    GameActivity.nivel = "survive";
                    Toast.makeText(getApplicationContext(),"60 segundos para acertar quantas palavras puder e assim conseguir maior HighScore! Tema aleatório.", Toast.LENGTH_SHORT).show();
                }
                    break;
        }
    }


}
