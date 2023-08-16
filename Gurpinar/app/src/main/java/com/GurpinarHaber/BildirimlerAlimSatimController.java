package com.GurpinarHaber;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BildirimlerAlimSatimController {

    public static final String url = "http://gilaburu.site/Gurpinar/";
    public static BildirimlerAlimSatimController clientobject;
    private static Retrofit retrofit;

    BildirimlerAlimSatimController(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized BildirimlerAlimSatimController getInstance(){

        if (clientobject == null)
            clientobject = new BildirimlerAlimSatimController();

        return clientobject;
    }

    IBildirimlerAlimSatim getapi(){
        return retrofit.create(IBildirimlerAlimSatim.class);
    }

    }

