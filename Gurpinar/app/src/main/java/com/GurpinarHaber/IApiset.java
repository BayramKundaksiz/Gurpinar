package com.GurpinarHaber;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApiset {

    @GET("json_user_fetch.php")

    Call<List<ResponseModel>> getdata();

}
