package com.GurpinarHaber;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IDuyurularOnemliGun {

    @GET("duyurular_onemli_gun_json_getir.php")
    Call<List<DuyurularOnemliGunConstructor>> duyurularOnemliGunGetir();


}
