package com.GurpinarHaber;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IDuyurularOtobus {

    @GET("duyurular_otobus_saatleri_json_getir.php")
    Call<List<DuyurularOtobusConstructor>> duyurularOtobus();

}
