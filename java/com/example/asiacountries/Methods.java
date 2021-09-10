package com.example.asiacountries;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {
    @GET("asia")
    Call<List<Model>> getAllData();
}
