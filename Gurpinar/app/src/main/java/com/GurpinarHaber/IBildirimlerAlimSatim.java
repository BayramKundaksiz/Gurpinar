package com.GurpinarHaber;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IBildirimlerAlimSatim {

    @GET("bildirimler_alimsatim_json_getir.php")
    Call<List<BildirimlerAlimSatimConstructor>> alimSatimGetir();

}
