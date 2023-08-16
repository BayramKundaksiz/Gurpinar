package com.GurpinarHaber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Nostalji extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<NostaljiConstructor> imageList;
    private NostaljiAdapter adapter;
    private Handler sliderHandler = new Handler();
    private Button nostaljiOtomatikGecisBaslat, nostaljiOtomatikGecisDuraksat;
    private Handler handler = new Handler();

    ImageView imagePlayPause;
    private MediaPlayer mediaPlayer;
    private AdView Nostaljibanner;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nostalji);

        MobileAds.initialize(Nostalji.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        Nostaljibanner = findViewById(R.id.NostaljiAdView);

        AdRequest adRequest = new AdRequest.Builder().build();
        Nostaljibanner.loadAd(adRequest);


        mediaPlayer = new MediaPlayer();
        imagePlayPause = findViewById(R.id.imagePlayPause);
        mediaPlayer = MediaPlayer.create(Nostalji.this,R.raw.hasretinle);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        imagePlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    Toast.makeText(Nostalji.this, "Müzik durduruldu", Toast.LENGTH_SHORT).show();
                    mediaPlayer.pause();
                    imagePlayPause.setImageResource(R.drawable.ic_baseline_music_off_24);
                }else {
                    Toast.makeText(Nostalji.this, "Müzik başlatıldı", Toast.LENGTH_SHORT).show();
                    mediaPlayer.start();
                    imagePlayPause.setImageResource(R.drawable.ic_baseline_music_note_24);
                }
            }
        });


        viewPager2 = findViewById(R.id.viewPager2);

        imageList = new ArrayList<>();

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#01A2D6")));
        setTitle("SİZDEN GELENLER");
        Toast.makeText(this, "Otomatik geçiş başlatıldı", Toast.LENGTH_LONG).show();


        NostaljiFotograflariGetir();

        nostaljiOtomatikGecisBaslat = findViewById(R.id.nostaljiOtomatikGecisBaslat);
        nostaljiOtomatikGecisDuraksat = findViewById(R.id.nostaljiOtomatikGecisDuraksat);

        nostaljiOtomatikGecisBaslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onResume();
                Toast.makeText(Nostalji.this, "Otomatik geçiş başlatıldı", Toast.LENGTH_SHORT).show();
            }
        });

        nostaljiOtomatikGecisDuraksat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sliderHandler.removeCallbacks(sliderRunnable);
                Toast.makeText(getApplicationContext(), "Otomatik geçiş durduruldu", Toast.LENGTH_SHORT).show();
            }
        });

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);

        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {

                if(position <= -1.0F || position >= 1.0F) {
                    page.setAlpha(0.0F);
                } else if( position == 0.0F ) {
                    page.setAlpha(1.0F);
                } else {
                    // position is between -1.0F & 0.0F OR 0.0F & 1.0F
                    page.setAlpha(1.0F - Math.abs(position));
                }
                float r = 1 - Math.abs(position);
                page.setScaleY((float) (0.85 + r * 0.14f));

            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 7500);

            }

        });



    }

    public void NostaljiFotograflariGetir() {

        Call<List<NostaljiConstructor>> call = NostaljiController
                .getInstance()
                .getapi()
                .nostaljiGetir();

        call.enqueue(new Callback<List<NostaljiConstructor>>() {
            @Override
            public void onResponse(Call<List<NostaljiConstructor>> call, Response<List<NostaljiConstructor>> response) {
                List<NostaljiConstructor> nostalji = response.body();
                NostaljiAdapter nostaljiAdapter = new NostaljiAdapter(nostalji, viewPager2);
                viewPager2.setAdapter(nostaljiAdapter);

            }

            @Override
            public void onFailure(Call<List<NostaljiConstructor>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Lütfen internet bağlantınızı kontrol ediniz", Toast.LENGTH_LONG).show();

            }
        });

    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 7500);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) || keyCode == KeyEvent.KEYCODE_HOME)
        {
            mediaPlayer.stop();
        }
        return super.onKeyDown(keyCode, event);
    }



    @Override
    public void onUserLeaveHint() {
        mediaPlayer.stop();
        imagePlayPause.setImageResource(R.drawable.ic_baseline_music_off_24);
        finish();
        super.onUserLeaveHint();
    }




}