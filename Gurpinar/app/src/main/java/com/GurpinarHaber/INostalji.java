package com.GurpinarHaber;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface INostalji {

    @GET("nostalji_json_getir.php")
    Call<List<NostaljiConstructor>> nostaljiGetir();

}
