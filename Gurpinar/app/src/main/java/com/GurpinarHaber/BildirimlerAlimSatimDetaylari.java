package com.GurpinarHaber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BildirimlerAlimSatimDetaylari extends AppCompatActivity {

    TextView textViewAlimSatimAdi, textViewAlimSatimDetayi;
    ImageView textViewAlimSatimGorseli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bildirimler_alim_satim_detaylari);

        textViewAlimSatimAdi = findViewById(R.id.textViewAlimSatimAdi);
        textViewAlimSatimDetayi = findViewById(R.id.textViewAlimSatimDetayi);
        textViewAlimSatimGorseli = findViewById(R.id.textViewAlimSatimGorseli);

        Intent intent = getIntent();

        String alimSatimAdi = intent.getStringExtra("alimsatimadi");
        String alimSatimDetayi = intent.getStringExtra("alimsatimbilgisi");
        String alimSatimGorseli = intent.getStringExtra("alimsatimfotografi");

        Glide.with(this)
                .load("http://gilaburu.site/Gurpinar/bildirimler/alimsatim/" +alimSatimGorseli).into(textViewAlimSatimGorseli);

        textViewAlimSatimAdi.setText(alimSatimAdi);
        textViewAlimSatimDetayi.setText(alimSatimDetayi);


    }
}