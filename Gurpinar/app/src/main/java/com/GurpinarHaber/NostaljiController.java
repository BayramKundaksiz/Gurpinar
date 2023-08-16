package com.GurpinarHaber;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NostaljiController {

    public static final String url = "http://gilaburu.site/Gurpinar/";
    public static NostaljiController clientobject;
    private static Retrofit retrofit;

    NostaljiController(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized NostaljiController getInstance(){

        if (clientobject == null)
            clientobject = new NostaljiController();

        return clientobject;
    }

    INostalji getapi(){
        return retrofit.create(INostalji.class);
    }

    }

