package com.icanerdogan.appvideogamesjavav1.model;

import android.content.Context;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icanerdogan.appvideogamesjavav1.adapter.RecyclerViewAdapter;
import com.icanerdogan.appvideogamesjavav1.service.GameAPIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitModel {

    public RetrofitModel() {
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final String BASE_URL = "https://api.rawg.io/api/";

    public void loadData(Context context, RecyclerView recyclerView){
        GameAPIService gameAPIService = retrofit.create(GameAPIService.class);

        Call<BaseModel> call = gameAPIService.getData();

        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                if (response.body() != null){
                    ArrayList<GameModel> gameList = response.body().getGame_results();

                    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(gameList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context.getApplicationContext()));
                    recyclerViewAdapter = new RecyclerViewAdapter(gameList);
                    recyclerView.setAdapter(recyclerViewAdapter);

                }
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
