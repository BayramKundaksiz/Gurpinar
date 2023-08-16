package com.GurpinarHaber;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BildirimlerUstalarController {

    public static final String url = "http://gilaburu.site/Gurpinar/";
    public static BildirimlerUstalarController clientobject;
    private static Retrofit retrofit;

    BildirimlerUstalarController(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized BildirimlerUstalarController getInstance(){

        if (clientobject == null)
            clientobject = new BildirimlerUstalarController();

        return clientobject;
    }

    IBildirimlerUstalar getapi(){
        return retrofit.create(IBildirimlerUstalar.class);
    }

    }

