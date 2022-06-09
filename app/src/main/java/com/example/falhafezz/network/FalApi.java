package com.example.falhafezz.network;

import com.example.falhafezz.model.Faal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FalApi {

    String BASE_URL = "https://ganjgah.ir/api/ganjoor/hafez/";

    @GET("faal")
    Call<Faal> getFal();
}
