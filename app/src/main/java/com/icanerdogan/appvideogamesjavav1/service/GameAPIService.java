package com.icanerdogan.appvideogamesjavav1.service;

import com.icanerdogan.appvideogamesjavav1.model.BaseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GameAPIService {

    // API KEY: games?key=YOUR_API_KEY
    // BASE URL: https://api.rawg.io/api/

    @GET("games?key=YOUR_API_KEY")
    Call<BaseModel> getData();
}
