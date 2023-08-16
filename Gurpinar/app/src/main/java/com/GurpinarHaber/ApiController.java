package com.GurpinarHaber;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {

    public static final String url = "http://gilaburu.site/Gurpinar/";
    public static ApiController clientobject;
    private static Retrofit retrofit;

    ApiController(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized ApiController getInstance(){

        if (clientobject == null)
            clientobject = new ApiController();

        return clientobject;
    }

    IApiset getapi(){
        return retrofit.create(IApiset.class);
    }

    }


