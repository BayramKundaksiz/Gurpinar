package com.GurpinarHaber;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DuyurularOtobusController {

    public static final String url = "http://gilaburu.site/Gurpinar/";
    public static DuyurularOtobusController clientobject;
    private static Retrofit retrofit;

    DuyurularOtobusController(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized DuyurularOtobusController getInstance(){

        if (clientobject == null)
            clientobject = new DuyurularOtobusController();

        return clientobject;
    }

    IDuyurularOtobus getapi(){
        return retrofit.create(IDuyurularOtobus.class);
    }

    }

