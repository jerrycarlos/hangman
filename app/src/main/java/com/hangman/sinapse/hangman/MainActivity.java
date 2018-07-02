package com.hangman.sinapse.hangman;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.GridLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.w3c.dom.Text;

import java.util.Vector;

public class MainActivity extends AppCompatActivity{
    private TextView scoreNormal, scoreDificil, scoreSurvive;
    private GridLayout gridScore;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btJogar = (Button) findViewById(R.id.btJogar);
        Button btSair = (Button) findViewById(R.id.btSair);
        gridScore = (GridLayout) findViewById(R.id.gridScore);
        scoreNormal = (TextView) findViewById(R.id.scoreNormal);
        scoreDificil = (TextView) findViewById(R.id.scoreDificil);
        scoreSurvive = (TextView) findViewById(R.id.scoreSurvive);
        MobileAds.initialize(this, "ca-app-pub-8152339859054893~5180090320");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-8152339859054893/7174153680");

        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void jogar(View v) {
        switch (v.getId()) {
            case R.id.btJogar:
                Intent i = new Intent(MainActivity.this, TelaTema.class);
                startActivity(i);
                break;
        }
    }

    public void exibeScore(View v){
        gridScore.setVisibility(View.VISIBLE);
        findViewById(R.id.btJogar).setEnabled(false);
        findViewById(R.id.btSair).setEnabled(false);
        findViewById(R.id.btAjuda).setEnabled(false);
        findViewById(R.id.btScore).setEnabled(false);
        carregaScore();
    }

    public void fechaScore(View v){
        gridScore.setVisibility(View.GONE);
        findViewById(R.id.btJogar).setEnabled(true);
        findViewById(R.id.btSair).setEnabled(true);
        findViewById(R.id.btAjuda).setEnabled(true);
        findViewById(R.id.btScore).setEnabled(true);
    }

    public static final String PREFS_NAME = "highscore";
    private void carregaScore(){
        int score = 0;
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if(settings.contains("scorenormal")) {
            scoreNormal.setText(""+settings.getInt("scorenormal", 0));
        }
        if(settings.contains("scoredificil")) {
            scoreDificil.setText(""+settings.getInt("scoredificil", 0));
        }
        if(settings.contains("scoresurvive")) {
            scoreSurvive.setText(""+settings.getInt("scoresurvive", 0));
        }
        //score = highscore.get(0);
        //txtScore.setText("Score: " + score);
    }

    public void onClickSair(View v){
        finish();
    }
}
