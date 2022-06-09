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

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fall extends AppCompatActivity {

    TextView poetry, number;
     ImageView back;
    String random_string = "";
    TextView textView;

    ImageView again;





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


        textView=findViewById(R.id.textView7);
        again = findViewById(R.id.imageView);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFaal();

            }
        });




        getFaal();

        int random_string_length = 5;
        String[] all_characters = {
                "از کار خیر دست برندار و دل دیگران را به دست بیاور. انسانی خیر باش. خداوند نیز یاور شما خواهد بود. اگر رکود موقتی در کار شما حادث شده، علتش ناشکری سال گذشته شما بود.",
                "از آنجایی که زندگی آرام داشته ای طاقت تحمل سختیها را نداری، اما بدان که اگر می خواهی به مقصود خود برسی باید رنج و مشقت بسیاری را تحمل نمایی. انسانهای بسیاری همچون تو در این راه قدم گذاشته اند و با صبر و بردباری به مقصود رسیده اند. ",
                "روزهای خوبی در پیش رو خواهی داشت. به زودی اتفاقات بسیار مثبتی در زندگیت روی می دهد که زندگیت را رونقی تازه می بخشد. به یاری خدا درهای بسته به رویت گشوده خواهد شد. در حال حاضر صلاح نیست که کار خود را عوض کنی. به کار قبلی خود ادامه بده .",
                "اگر قصد انجام این نیت را داری باید در مقابل مشکلات و سختی های این راه ناهموار صبر و تحمل داشته باشی و با شکیبایی قدم به قدم پیش بروی و بدان که هرچه انسانی دارای مقام و قدرت باشد، بدون یاری خدا از عهده هیچ کاری بر نخواهد آمد. پس به خدا توکل کن .",
                "شما اکنون در بهار عمر خود به سر می برید و بهتر آن است که تا آنجا که می توانی از لذت های زندگی استفاده کنی و زندگی را بر خود و دیگران سخت نگیری. از چشم حسودان و بدخواهان به خدا پناه ببر و از نعماتی که خدا در اختیارت گذارده است، نهایت استفاده را ببر .",
                "عزیزی را از دست داده ای که می اندیشی هیچ کس در دنیا جای خالی او را برایت پر نمی کند و این موضوع تو را به شدت غمناک و بی تاب کرده است. فکر می کنی تمام زندگیت به او وابسته بود و اکنون که او رفته زندگی تو نیز فنا شده است. \n"
        };
        int all_characters_length = all_characters.length;

        int min = 0;
        int max = all_characters_length-1;



        Random r = new Random();
        int random_number = r.nextInt(max - min + 1) + min;
        String random_character = all_characters[random_number];
        random_string = random_string + random_character;












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
                    textView.setText(random_string);








                }
            }

            @Override
            public void onFailure(Call<Faal> call, Throwable t) {
                Toast.makeText(fall.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}