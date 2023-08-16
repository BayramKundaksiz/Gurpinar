package com.GurpinarHaber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class AcilisSayfasi extends AppCompatActivity {

    Animation zoom;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acilis_sayfasi);

        zoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        img = findViewById(R.id.image);
        img.startAnimation(zoom);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#01A2D6")));

        setTitle("HOŞGELDİNİZ");


        String value = getIntent().getStringExtra("bildirim_keyi");

        if (value != null){
            Intent bildirimeGonder = new Intent(getApplicationContext(), BildirimGonder.class);
            startActivity(bildirimeGonder);
            finish();
        }else {
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }, 4500);
        }




    }


}