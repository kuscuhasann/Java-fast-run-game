package com.info.oyuncalismasi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SonucEkraniActivity extends AppCompatActivity {

    private TextView textViewToplamSkor;
    private TextView textViewEnYuksekSkor;
    private Button buttonTekrarDene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc_ekrani);

        textViewToplamSkor = findViewById(R.id.textViewToplamSkor);
        textViewEnYuksekSkor = findViewById(R.id.textViewEnYuksekSkor);
        buttonTekrarDene = findViewById(R.id.buttonTekrarDene);

        int skor = getIntent().getIntExtra("skor",0);
        textViewToplamSkor.setText(String.valueOf(skor));

        SharedPreferences sp = getSharedPreferences("Sonuc",Context.MODE_PRIVATE);
        int enYuksekSkor = sp.getInt("enYuksekSkor",0);

        if (skor > enYuksekSkor){

            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("enYuksekSkor",skor);
            editor.commit();

            textViewEnYuksekSkor.setText(String.valueOf(skor));

        }else{
            textViewEnYuksekSkor.setText(String.valueOf(enYuksekSkor));
        }


        buttonTekrarDene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SonucEkraniActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
