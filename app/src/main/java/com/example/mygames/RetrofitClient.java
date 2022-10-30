package com.example.mygames;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private Api myApi;

    private final static String BASE_URL = "https://www.freetogame.com/api/";

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if (instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }
    public Api getMyApi(){
        return myApi;
    }

}
