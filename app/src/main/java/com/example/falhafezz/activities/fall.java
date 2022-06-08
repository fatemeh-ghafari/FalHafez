package com.example.falhafezz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.falhafezz.R;

public class fall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fall);

        ImageView im;
        im=findViewById(R.id.imageView2);
        im.setOnClickListener(v->  {
            Intent intent = new Intent(fall.this, MainActivity.class);
            startActivity(intent);

        });

    }
}