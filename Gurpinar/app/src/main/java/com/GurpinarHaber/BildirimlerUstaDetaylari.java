package com.GurpinarHaber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BildirimlerUstaDetaylari extends AppCompatActivity {

    TextView textViewUstaninAdi, textViewUstaninAlani;
    ImageView imageViewUstaninGorseli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bildirimler_usta_detaylari);

        textViewUstaninAdi = findViewById(R.id.textViewUstaninAdi);
        textViewUstaninAlani = findViewById(R.id.textViewUstaninAlani);
        imageViewUstaninGorseli = findViewById(R.id.imageViewUstaninGorseli);

        Intent intent = getIntent();

        String ustaninAdi = intent.getStringExtra("ustaAdi");
        String ustaninAlani = intent.getStringExtra("ustaAlani");
        String ustaninGorseli = intent.getStringExtra("ustaninGorseli");

        Glide.with(this)
                .load("http://gilaburu.site/Gurpinar/bildirimler/ustalar/" +ustaninGorseli).into(imageViewUstaninGorseli);

        textViewUstaninAdi.setText(ustaninAdi);
        textViewUstaninAlani.setText(ustaninAlani);


    }
}