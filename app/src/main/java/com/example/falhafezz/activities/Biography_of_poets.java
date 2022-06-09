package com.example.falhafezz.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

;


import com.example.falhafezz.Adapter.PoetAdapter;
import com.example.falhafezz.R;
import com.example.falhafezz.model.Poet;
import com.example.falhafezz.network.Bio;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Biography_of_poets extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PoetAdapter adapter;
    List<Poet> poets;
ImageView backward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biography_of_poets);


        backward=findViewById(R.id.imageView3);
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Biography_of_poets.this, MainActivity.class);
                startActivity(intent);
            }
        });













        recyclerView = findViewById(R.id.BioRV);
        poets = new ArrayList<>();


        adapter = new PoetAdapter(getApplicationContext(), poets);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Bio.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Bio bioApi = retrofit.create(Bio.class);
        Call<List<Poet>> call = bioApi.getPoets();
        call.enqueue(new Callback<List<Poet>>() {
            @Override
            public void onResponse(Call<List<Poet>> call, Response<List<Poet>> response) {
                if (response.isSuccessful()) {
                    poets.clear();
                    poets.addAll(response.body());
                    //Toast.makeText(Biography_of_poets.this, "" + poets.get(0).getName(), Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Poet>> call, Throwable t) {
                Toast.makeText(Biography_of_poets.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });

    }
}