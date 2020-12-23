package com.example.sanafinalproject;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface RInterface {
    @GET("repositories")
    Call<List<Custom>> getCarsJson();
}
