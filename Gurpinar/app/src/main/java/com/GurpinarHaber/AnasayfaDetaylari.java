package com.GurpinarHaber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AnasayfaDetaylari extends AppCompatActivity {

    TextView textView,textViewDetay;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa_detaylari);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        textViewDetay = findViewById(R.id.textViewDetay);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String detail = intent.getStringExtra("detaylar");
        String goruntu = intent.getStringExtra("resim");

        Glide.with(this)
                .load("http://gilaburu.site/Gurpinar/resimler/" +goruntu).into(imageView);
        textView.setText(name);
        textViewDetay.setText(detail);
    }
}