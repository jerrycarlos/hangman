package com.hangman.sinapse.hangman;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import java.lang.String;
import java.util.Vector;

import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class GameActivity extends AppCompatActivity implements OnClickListener{
    static String tema, nivel = "";
    char letra;
    static String palavra;
    static String[] palavraAux;
    private Vector<String> historicoPalavra;
    static TextView txtTema, txtScore;
    LinearLayout teclado;
    Button novojogo, novotema;
    ImageView imgForca;
    GridLayout gridNovoJogo;
    private Vector<Integer> highscore;
    private int score, contHistorico;
    static int tamPalavra = 0;
    static boolean acertou = false, fimPartida = false;
    private boolean zerouTema = false;
    static int acertos = 0, erros = 0;
    static Button bA, bB, bC, bD, bE, bF, bG, bH, bI, bJ, bK, bL, bM, bN, bO, bP, bQ, bR, bS, bT, bU, bV, bW, bX, bY, bZ, bCc;
    static Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17;

    SortWord sortWord;
    private AdView mAdView;
    public static final String PREFS_NAME = "highscore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        Intent it = getIntent();
        if(it != null) {
            Bundle params = it.getExtras();
            if (params != null) {
                this.tema = params.getString("tema");
                //nivel = params.getString("nivel");
            }
        }
        highscore = new Vector<Integer>();
        historicoPalavra = new Vector<String>();
        contHistorico = 0;
        score = 0;
        sortWord = new SortWord();
        iniciarObjetos();
        iniciarJogo();
        MobileAds.initialize(this, "ca-app-pub-8152339859054893~5180090320");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-8152339859054893/3429268228");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        if(settings.contains("scoreResume")){
            editor.putInt("scoreResume",0);
            editor.commit();
        }


    }

    @Override
    public void onStart(){
        super.onStart();
        iniciarObjetos();
        Intent it = getIntent();
        if(it != null) {
            Bundle params = it.getExtras();
            if (params != null) {
                this.tema = params.getString("tema");
                //nivel = params.getString("nivel");
            }
        }
        escondeBotoes();
        imgForca.setImageResource(R.drawable.forca);
        gridNovoJogo.setVisibility(View.GONE);
        teclado.setVisibility(View.VISIBLE);
        //palavra = sortWord.sorteio();
        //tema = sortWord.tema;
        tamPalavra = palavra.length();
        palavraAux = new String[tamPalavra];
        erros = 0;
        acertos = 0;
        acertou = false;
        fimPartida = false;
        letra = ' ';
        txtTema.setText(tema);
        preenchePalavra();
        habilitarBotoes();
    }

    @Override
    public void onBackPressed(){
        salvaScore();
        super.onBackPressed();
    }


    @Override
    public void onPause(){
        super.onPause();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("scoreResume",score);
        //editor.putString("palavraAtual",palavra);
        //editor.putString("temaAtual",tema);
        editor.commit();
    }

    private void recuperaDados(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        if(settings.contains("scoreResume")) {
            score = settings.getInt("scoreResume",0);
            txtScore.setText("Score: "+score);
        }
        //if(settings.contains("palavraAtual") && settings.contains("temaAtual")){
          //  palavra = settings.getString("palavraAtual","");
          //  tema = settings.getString("temaAtual","");
            //txtTema.setText(tema);
            //preenchePalavra();
        //}
    }

    @Override
    public void onResume(){
        super.onResume();
        recuperaDados();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        if(settings.contains("scoreResume")){
            editor.remove("scoreResume");
        }
    }

    public void vazio(View v){

    }

    private void salvaScore(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("scoreResume",score);
        editor.commit();
        int i = 0;
        int aux = 0;
        if(settings.contains("score"+nivel)) {
                aux = settings.getInt("score"+nivel,0);
                if(score > aux){
                    editor.putInt("score"+nivel,score);
                }
        }else
            editor.putInt("score"+nivel,score);
        editor.commit();
    }


    public void onClick(View v){
        Jogo.escondeBotao(v);
        Jogo.verificarClick(v);
        if(!this.acertou)
            pintaImgErro();
        verificaPartida();
    }

    public void onClickNovoJogo(View v){
        iniciarJogo();
    }

    private void iniciarJogo() {
        escondeBotoes();
        zerouTema = false;
        imgForca.setImageResource(R.drawable.forca);
        novojogo.setVisibility(View.VISIBLE);
        novotema.setVisibility(View.GONE);
        gridNovoJogo.setVisibility(View.GONE);
        teclado.setVisibility(View.VISIBLE);
        palavra = sortWord.sorteio();
        contHistorico++;
        if(contHistorico<=sortWord.getTamanho()) {
            //historicoPalavra.add(palavra);
            if(historicoPalavra.size() < 1)
                historicoPalavra.add(palavra);
            else if(!historicoPalavra.contains(palavra)) {
                historicoPalavra.add(palavra);
            }
            else{
                while (historicoPalavra.contains(palavra) && (historicoPalavra.size() > 1)) {
                    //historicoPalavra.remove(historicoPalavra.size() - 1);
                    palavra = sortWord.sorteio();
                }
                historicoPalavra.add(palavra);
            }
        }
        else{
            contHistorico = 0;
            historicoPalavra.removeAllElements();
            zerouTema = true;
            //zerouTema();
        }

        //tema = sortWord.tema;
        tamPalavra = palavra.length();
        palavraAux = new String[tamPalavra];
        erros = 0;
        acertos = 0;
        acertou = false;
        fimPartida = false;
        letra = ' ';
        txtTema.setText(tema);
        preenchePalavra();

        habilitarBotoes();
        //tvPalavra.setText(tracos);
        //forca.setImageResource(R.drawable.forca_6);
    }

    private void preenchePalavra(){
        for (int x = 0; x < palavra.length(); x++) {
            if (palavra.charAt(x) == ' ' || palavra.charAt(x) == '-' || palavra.charAt(x) == '(' || palavra.charAt(x) == ')' || palavra.charAt(x) == '/' || palavra.charAt(x) == '?') {
                pintaBotao(x, Character.toString(palavra.charAt(x)));
                palavraAux[x] = "*";
                acertos++;
            } else{
                pintaBotao(x, "_");
                palavraAux[x] = Character.toString(palavra.charAt(x));
            }
            //pintaBotao(x,Character.toString(palavra.charAt(x)));
        }
    }
    private void verificaPartida(){
        if(fimPartida)
            fimJogo();
    }

    private void pintaImgErro(){
        if(GameActivity.erros <= 1)
            imgForca.setImageResource(R.drawable.forca01);
        else if(GameActivity.erros <= 2)
            imgForca.setImageResource(R.drawable.forca02);
        else if(GameActivity.erros <= 3)
            imgForca.setImageResource(R.drawable.forca03);
        else if(GameActivity.erros <= 4)
            imgForca.setImageResource(R.drawable.forca04);
        else if(GameActivity.erros <= 5)
            imgForca.setImageResource(R.drawable.forca05);
        else
            imgForca.setImageResource(R.drawable.forca06);

    }

    public void onClickDica(View v){
        if(this.tema.equals("cidades"))
            Toast.makeText(getApplicationContext(),"dica: " + sortWord.getDica(), Toast.LENGTH_SHORT).show();
        else{
            int pos = sortWord.dica(palavraAux);
            //pintaBotao(pos,palavraAux[pos]);
            //Toast.makeText(getApplicationContext(),"dica: " + palavraAux[pos], Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),"dica: " + sortWord.getDica(),Toast.LENGTH_LONG).show();
        }
    }

    private void fimJogo(){
        if(erros==6)
            txtTema.setText("Não foi dessa vez, quem sabe na próxima!");
        else {
            if(contHistorico == sortWord.getTamanho())
                zerouTema();
            else {
                score += 10;
                txtTema.setText("Parábens, você ganhou!");
                txtScore.setText("Score: " + score);
                imgForca.setImageResource(R.drawable.forca101);
                salvaScore();
            }
        }
        desabilitaTeclado();
    }

    private void zerouTema(){
        desabilitaTeclado();
        novojogo.setVisibility(View.GONE);
        novotema.setVisibility(View.VISIBLE);
        score += 60;
        txtTema.setText("Parábens, você zerou este tema! Bônus de +50 pts");
        txtScore.setText("Score: " + score);
        imgForca.setImageResource(R.drawable.forca101);
        salvaScore();
    }


    private void desabilitaTeclado(){
        teclado.setVisibility(View.GONE);
        gridNovoJogo.setVisibility(View.VISIBLE);
        desabilitarBotoes();
    }

    public void novoTema(View v){
        tema = sortWord.sorteiaTema();
        iniciarJogo();
    }

    protected static void pintaBotao(int bt, String letra){
        switch (bt){
            case 0:
                b0.setVisibility(View.VISIBLE);
                b0.setText(letra);
                break;
            case 1:
                b1.setVisibility(View.VISIBLE);
                b1.setText(letra);
                break;
            case 2:
                b2.setVisibility(View.VISIBLE);
                b2.setText(letra);
                break;
            case 3:
                b3.setVisibility(View.VISIBLE);
                b3.setText(letra);
                break;
            case 4:
                b4.setVisibility(View.VISIBLE);
                b4.setText(letra);
                break;
            case 5:
                b5.setVisibility(View.VISIBLE);
                b5.setText(letra);
                break;
            case 6:
                b6.setVisibility(View.VISIBLE);
                b6.setText(letra);
                break;
            case 7:
                b7.setVisibility(View.VISIBLE);
                b7.setText(letra);
                break;
            case 8:
                b8.setVisibility(View.VISIBLE);
                b8.setText(letra);
                break;
            case 9:
                b9.setVisibility(View.VISIBLE);
                b9.setText(letra);
                break;
            case 10:
                b10.setVisibility(View.VISIBLE);
                b10.setText(letra);
                break;
            case 11:
                b11.setVisibility(View.VISIBLE);
                b11.setText(letra);
                break;
            case 12:
                b12.setVisibility(View.VISIBLE);
                b12.setText(letra);
                break;
            case 13:
                b13.setVisibility(View.VISIBLE);
                b13.setText(letra);
                break;
            case 14:
                b14.setVisibility(View.VISIBLE);
                b14.setText(letra);
                break;
            case 15:
                b15.setVisibility(View.VISIBLE);
                b15.setText(letra);
                break;
            case 16:
                b16.setVisibility(View.VISIBLE);
                b16.setText(letra);
                break;
            case 17:
                b17.setVisibility(View.VISIBLE);
                b17.setText(letra);
                break;
        }
    }

    private void iniciarObjetos() {
        teclado = (LinearLayout) findViewById(R.id.teclado);//layout do teclado
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtTema = (TextView) findViewById(R.id.txtTema);//String do tema
        imgForca = (ImageView) findViewById(R.id.imgForca);//grid da imagem
        imgForca.setImageResource(R.drawable.forca);
        gridNovoJogo = (GridLayout) findViewById(R.id.gridNovoJogo);//grid do botao novo jogo
        novojogo = (Button) findViewById(R.id.btNovoJogo);
        novotema = (Button) findViewById(R.id.btTema);
        bA = (Button) findViewById(R.id.bA);
        bB = (Button) findViewById(R.id.bB);
        bC = (Button) findViewById(R.id.bC);
        bD = (Button) findViewById(R.id.bD);
        bE = (Button) findViewById(R.id.bE);
        bF = (Button) findViewById(R.id.bF);
        bG = (Button) findViewById(R.id.bG);
        bH = (Button) findViewById(R.id.bH);
        bI = (Button) findViewById(R.id.bI);
        bJ = (Button) findViewById(R.id.bJ);
        bK = (Button) findViewById(R.id.bK);
        bL = (Button) findViewById(R.id.bL);
        bM = (Button) findViewById(R.id.bM);
        bN = (Button) findViewById(R.id.bN);
        bO = (Button) findViewById(R.id.bO);
        bP = (Button) findViewById(R.id.bP);
        bQ = (Button) findViewById(R.id.bQ);
        bR = (Button) findViewById(R.id.bR);
        bS = (Button) findViewById(R.id.bS);
        bT = (Button) findViewById(R.id.bT);
        bU = (Button) findViewById(R.id.bU);
        bV = (Button) findViewById(R.id.bV);
        bW = (Button) findViewById(R.id.bW);
        bX = (Button) findViewById(R.id.bX);
        bY = (Button) findViewById(R.id.bY);
        bZ = (Button) findViewById(R.id.bZ);
        bCc = (Button) findViewById(R.id.bCc);
        b0 = (Button) findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b13 = (Button) findViewById(R.id.b13);
        b14 = (Button) findViewById(R.id.b14);
        b15 = (Button) findViewById(R.id.b15);
        b16 = (Button) findViewById(R.id.b16);
        b17 = (Button) findViewById(R.id.b17);
        bA.setOnClickListener(this);
        bB.setOnClickListener(this);
        bC.setOnClickListener(this);
        bD.setOnClickListener(this);
        bE.setOnClickListener(this);
        bF.setOnClickListener(this);
        bG.setOnClickListener(this);
        bH.setOnClickListener(this);
        bI.setOnClickListener(this);
        bJ.setOnClickListener(this);
        bK.setOnClickListener(this);
        bL.setOnClickListener(this);
        bM.setOnClickListener(this);
        bN.setOnClickListener(this);
        bO.setOnClickListener(this);
        bP.setOnClickListener(this);
        bQ.setOnClickListener(this);
        bR.setOnClickListener(this);
        bS.setOnClickListener(this);
        bT.setOnClickListener(this);
        bU.setOnClickListener(this);
        bV.setOnClickListener(this);
        bW.setOnClickListener(this);
        bX.setOnClickListener(this);
        bY.setOnClickListener(this);
        bZ.setOnClickListener(this);
        bCc.setOnClickListener(this);
        escondeBotoes();
    }


    private void escondeBotoes(){
        b0.setVisibility(View.INVISIBLE);
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
        b5.setVisibility(View.INVISIBLE);
        b6.setVisibility(View.INVISIBLE);
        b7.setVisibility(View.INVISIBLE);
        b8.setVisibility(View.INVISIBLE);
        b9.setVisibility(View.INVISIBLE);
        b10.setVisibility(View.INVISIBLE);
        b11.setVisibility(View.INVISIBLE);
        b12.setVisibility(View.INVISIBLE);
        b13.setVisibility(View.INVISIBLE);
        b14.setVisibility(View.INVISIBLE);
        b15.setVisibility(View.INVISIBLE);
        b16.setVisibility(View.INVISIBLE);
        b17.setVisibility(View.INVISIBLE);
    }

    private void habilitarBotoes() {
        bA.setEnabled(true);
        bB.setEnabled(true);
        bC.setEnabled(true);
        bD.setEnabled(true);
        bE.setEnabled(true);
        bF.setEnabled(true);
        bG.setEnabled(true);
        bH.setEnabled(true);
        bI.setEnabled(true);
        bJ.setEnabled(true);
        bK.setEnabled(true);
        bL.setEnabled(true);
        bM.setEnabled(true);
        bN.setEnabled(true);
        bO.setEnabled(true);
        bP.setEnabled(true);
        bQ.setEnabled(true);
        bR.setEnabled(true);
        bS.setEnabled(true);
        bT.setEnabled(true);
        bU.setEnabled(true);
        bV.setEnabled(true);
        bW.setEnabled(true);
        bX.setEnabled(true);
        bY.setEnabled(true);
        bZ.setEnabled(true);
        bCc.setEnabled(true);
        b0.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        b10.setEnabled(true);
        b11.setEnabled(true);
        b12.setEnabled(true);
        b13.setEnabled(true);
        b14.setEnabled(true);
        b15.setEnabled(true);
        b16.setEnabled(true);
        b17.setEnabled(true);
        bA.setVisibility(View.VISIBLE);
        bB.setVisibility(View.VISIBLE);
        bC.setVisibility(View.VISIBLE);
        bD.setVisibility(View.VISIBLE);
        bE.setVisibility(View.VISIBLE);
        bF.setVisibility(View.VISIBLE);
        bG.setVisibility(View.VISIBLE);
        bH.setVisibility(View.VISIBLE);
        bI.setVisibility(View.VISIBLE);
        bJ.setVisibility(View.VISIBLE);
        bK.setVisibility(View.VISIBLE);
        bL.setVisibility(View.VISIBLE);
        bM.setVisibility(View.VISIBLE);
        bN.setVisibility(View.VISIBLE);
        bO.setVisibility(View.VISIBLE);
        bP.setVisibility(View.VISIBLE);
        bQ.setVisibility(View.VISIBLE);
        bR.setVisibility(View.VISIBLE);
        bS.setVisibility(View.VISIBLE);
        bT.setVisibility(View.VISIBLE);
        bU.setVisibility(View.VISIBLE);
        bV.setVisibility(View.VISIBLE);
        bW.setVisibility(View.VISIBLE);
        bX.setVisibility(View.VISIBLE);
        bY.setVisibility(View.VISIBLE);
        bZ.setVisibility(View.VISIBLE);
        bCc.setVisibility(View.VISIBLE);
    }

    private void desabilitarBotoes() {
        bA.setEnabled(false);
        bB.setEnabled(false);
        bC.setEnabled(false);
        bD.setEnabled(false);
        bE.setEnabled(false);
        bF.setEnabled(false);
        bG.setEnabled(false);
        bH.setEnabled(false);
        bI.setEnabled(false);
        bJ.setEnabled(false);
        bK.setEnabled(false);
        bL.setEnabled(false);
        bM.setEnabled(false);
        bN.setEnabled(false);
        bO.setEnabled(false);
        bP.setEnabled(false);
        bQ.setEnabled(false);
        bR.setEnabled(false);
        bS.setEnabled(false);
        bT.setEnabled(false);
        bU.setEnabled(false);
        bV.setEnabled(false);
        bW.setEnabled(false);
        bX.setEnabled(false);
        bY.setEnabled(false);
        bZ.setEnabled(false);
        bCc.setEnabled(false);
        b0.setEnabled(false);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        b10.setEnabled(false);
        b11.setEnabled(false);
        b12.setEnabled(false);
        b13.setEnabled(false);
        b14.setEnabled(false);
        b15.setEnabled(false);
        b16.setEnabled(false);
        b17.setEnabled(false);
    }

}
