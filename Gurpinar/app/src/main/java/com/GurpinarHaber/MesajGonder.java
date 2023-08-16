package com.GurpinarHaber;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;

import android.provider.MediaStore;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class MesajGonder extends AppCompatActivity {

    TextView textViewFacebook,textViewTwitter,textViewEposta,textViewTelegram;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesaj_gonder);


        textViewFacebook = findViewById(R.id.textViewFacebook);
        textViewTwitter = findViewById(R.id.textViewTwitter);
        textViewEposta = findViewById(R.id.textViewEposta);
        textViewTelegram = findViewById(R.id.textViewTelegram);

        textViewFacebook.setMovementMethod(LinkMovementMethod.getInstance());
        textViewTwitter.setMovementMethod(LinkMovementMethod.getInstance());
        textViewEposta.setMovementMethod(LinkMovementMethod.getInstance());
        textViewTelegram.setMovementMethod(LinkMovementMethod.getInstance());



    }
}