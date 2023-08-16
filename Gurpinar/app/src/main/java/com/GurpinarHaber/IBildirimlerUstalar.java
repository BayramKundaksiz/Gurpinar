package com.GurpinarHaber;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IBildirimlerUstalar {

    @GET("bildirimler_ustalar_json_getir.php")
    Call<List<BildirimlerUstalarConstructor>> ustalariGetir();

}
