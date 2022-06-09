package com.example.falhafezz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.falhafezz.R;
import com.example.falhafezz.model.Faal;
import com.example.falhafezz.network.FalApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fall extends AppCompatActivity {

    TextView poetry, number;
     ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fall);

        poetry = findViewById(R.id.Poetry);
        number = findViewById(R.id.number_ghazal);
        back=findViewById(R.id.imageView2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fall.this, MainActivity.class);
                startActivity(intent);
            }
        });


        getFaal();





    }


    private void getFaal() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FalApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FalApi falApi = retrofit.create(FalApi.class);
        Call<Faal> call = falApi.getFal();
        call.enqueue(new Callback<Faal>() {
            @Override
            public void onResponse(Call<Faal> call, Response<Faal> response) {
                if (response.isSuccessful()) {
                    Faal faal = response.body();
                    number.setText(faal.getTitle());
                    poetry.setText(faal.getPlainText());
                }
            }

            @Override
            public void onFailure(Call<Faal> call, Throwable t) {
                Toast.makeText(fall.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}