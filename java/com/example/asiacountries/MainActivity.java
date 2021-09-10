package com.example.asiacountries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    //TextView tv;
    RecyclerView recyclerView;
    String url="https://restcountries.eu/rest/v2/region/";
    private List<Model> model;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        model=new ArrayList<>();


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Methods api=retrofit.create(Methods.class);

        Call<List<Model>> call=api.getAllData();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> data=response.body();

                for(Model m: data)
                    model.add(new Model(m.getName(),m.getFlag(),m.getCapital(),m.getRegion(),m.getSubRegion(),m.getPopulation(),m.getBorder()));


                RecyclerAdapter recyclerAdapter=new RecyclerAdapter(model);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {


            }
        });

    }

}