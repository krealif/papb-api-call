package com.example.mygames;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("games?platform=pc&sort-by=popularity")
    Call<ArrayList<Games>> getGames();

}
