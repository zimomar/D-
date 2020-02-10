package com.androiddev.tp3;

import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SoundPool soundPool;
    private Button lancer;
    private ImageView de1;
    private ImageView de2;
    private ImageView de3;
    private Random rand = new Random();
    private int sound;
    private TextView resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        de1 = (ImageView) findViewById(R.id.de1);
        de2 = (ImageView) findViewById(R.id.de2);
        de3 = (ImageView) findViewById(R.id.de3);
        lancer = (Button) findViewById(R.id.buttonMelange);
        resultat = (TextView) findViewById(R.id.resultat);

        lancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichageDe();
            }
        });
    }
    public int randomValue(){
        return rand.nextInt(6) + 1;
    }
    public void jouerGif(){
        int value1 = randomValue();
        int value2 = randomValue();
        int value3 = randomValue();
        int res1, res2, res3;

        res1 = getResources().getIdentifier("degif","drawable","com.androiddev.tp3");
        res2 = getResources().getIdentifier("degif","drawable","com.androiddev.tp3");
        res3 = getResources().getIdentifier("degif","drawable","com.androiddev.tp3");

        this.de1.setImageResource(res1);
        this.de2.setImageResource(res2);
        this.de3.setImageResource(res3);
    }

    public void affichageDe(){
        int value1 = randomValue();
        int value2 = randomValue();
        int value3 = randomValue();
        int res1, res2, res3;

        res1 = getResources().getIdentifier("de"+value1,"drawable","com.androiddev.tp3");
        res2 = getResources().getIdentifier("de"+value2,"drawable","com.androiddev.tp3");
        res3 = getResources().getIdentifier("de"+value3,"drawable","com.androiddev.tp3");

        de1.setImageResource(res1);
        de2.setImageResource(res2);
        de3.setImageResource(res3);

        int res = value1+value2+value3;

        resultat.setText(Integer.toString(res));
    }

    public void InitSon(){
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
        this.sound = soundPool.load("this.R.raw.shake_dice",1);
    }
    public void playSon(){
        soundPool.play(sound,1,1,0,0,1);
    }
}
