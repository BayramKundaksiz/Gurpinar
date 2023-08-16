package com.GurpinarHaber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class OtobusDetaylari extends AppCompatActivity {

    TextView OtobusSaatiTextViewTextView;
    ImageView imageViewOtobusSaatiImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otobus_detaylari);


        OtobusSaatiTextViewTextView = findViewById(R.id.OtobusSaatiTextViewTextView);
        imageViewOtobusSaatiImageView = findViewById(R.id.imageViewOtobusSaatiImageView);


        Intent intent = getIntent();

        String name = intent.getStringExtra("isim");

        String otobus = intent.getStringExtra("otobus");

        Glide.with(this)
                .load("http://gilaburu.site/Gurpinar/duyurular/OtobusSaatleri/" +otobus).into(imageViewOtobusSaatiImageView);

        OtobusSaatiTextViewTextView.setText(name);


    }
}