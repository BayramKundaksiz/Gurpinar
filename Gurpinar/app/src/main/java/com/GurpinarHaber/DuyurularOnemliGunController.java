package com.GurpinarHaber;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DuyurularOnemliGunController {

    public static final String url = "http://gilaburu.site/Gurpinar/";
    public static DuyurularOnemliGunController clientobject;
    private static Retrofit retrofit;

    DuyurularOnemliGunController(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized DuyurularOnemliGunController getInstance(){

        if (clientobject == null)
            clientobject = new DuyurularOnemliGunController();

        return clientobject;
    }

    IDuyurularOnemliGun getapi(){
        return retrofit.create(IDuyurularOnemliGun.class);
    }

    }

