package com.example.mygames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Games> games = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;
    private ProgressBar progressBar;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        recyclerView = findViewById(R.id.rv);
        progressBar = findViewById(R.id.progressBar);
        recyclerView.setVisibility(View.INVISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        getListGames();
    }

    private void getListGames() {
        Call<ArrayList<Games>> caller = RetrofitClient.getInstance().getMyApi().getGames();
        caller.enqueue(new Callback<ArrayList<Games>>() {
            @Override
            public void onResponse(Call<ArrayList<Games>> call, Response<ArrayList<Games>> response) {
                games = response.body();
                recyclerAdapter = new RecyclerAdapter(context, games);
                recyclerView.setAdapter(recyclerAdapter);
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<ArrayList<Games>> call, Throwable t) {

            }
        });
    }
}