package com.GurpinarHaber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class OnemliGunDuyuruDetaylari extends AppCompatActivity {

    TextView textViewOnemliGunDuyuruAdi, textViewOnemliGunDuyuruDetayi;
    ImageView imageViewDuyuruGorseli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onemli_gun_duyuru_detaylari);

        textViewOnemliGunDuyuruAdi = findViewById(R.id.textViewOnemliGunDuyuruAdi);
        textViewOnemliGunDuyuruDetayi = findViewById(R.id.textViewOnemliGunDuyuruDetayi);
        imageViewDuyuruGorseli = findViewById(R.id.imageViewDuyuruGorseli);

        Intent intent = getIntent();

        String duyuruAdi = intent.getStringExtra("duyuruadi");
        String duyuruDetayi = intent.getStringExtra("duyuruiletisim");
        String duyuruResmi = intent.getStringExtra("duyuruResmi");

        Glide.with(this)
                .load("http://gilaburu.site/Gurpinar/duyurular/OnemliGunler/" +duyuruResmi).into(imageViewDuyuruGorseli);

        textViewOnemliGunDuyuruAdi.setText(duyuruAdi);
        textViewOnemliGunDuyuruDetayi.setText(duyuruDetayi);



    }
}