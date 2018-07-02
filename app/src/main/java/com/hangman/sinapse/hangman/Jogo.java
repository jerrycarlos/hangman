package com.hangman.sinapse.hangman;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jerry Jr on 28/02/2018.
 */

public class Jogo {

    protected static void verificarClick(View v) {

        Button b = (Button) v;
        String letraBotao = b.getText().toString().toLowerCase();
        char letra;
        GameActivity.acertou = false;
        String palavratoLowerCase = GameActivity.palavra.toLowerCase();
        for (int x = 0; x < palavratoLowerCase.length(); x++) {
            letra = verificaVogais(palavratoLowerCase.charAt(x));
            if (letra == letraBotao.charAt(0)) {//if(letraBotao == Character.toString(letra)){ Character.toString(letra).toUpperCase()
                GameActivity.pintaBotao(x, Character.toString(GameActivity.palavra.charAt(x)));
                GameActivity.palavraAux[x] = "*";
                GameActivity.acertos++;
                GameActivity.acertou = true;
            }
        }
        if(!GameActivity.acertou){
            //GameActivity.acertou = false;
            GameActivity.erros++;
        }
        if((GameActivity.erros == 6) || (GameActivity.acertos == GameActivity.tamPalavra)){
            GameActivity.fimPartida = true;
        }
    }

    protected static void escondeBotao(View v){
        v.setVisibility(View.INVISIBLE);
    }

    private static char verificaVogais(char letra){
        char vogal = letra;
        if(letra == 'á' || letra == 'â' || letra == 'ã')
            vogal = 'a';
        else if(letra == 'ó' || letra == 'ô' || letra == 'õ')
            vogal = 'o';
        else if(letra == 'é' || letra == 'ê')
            vogal = 'e';
        else if(letra == 'í' || letra == 'î')
            vogal = 'i';
        else if(letra == 'ú' || letra == 'û')
            vogal = 'u';
        return vogal;
    }

}
