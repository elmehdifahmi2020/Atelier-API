package com.example.atelierapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public ListView lv;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv= findViewById(R.id.lv);
        //btn=findViewById(R.id.btn);

        ArrayAdapter<Todo> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getTodo().enqueue(new Callback<List<Todo>>() {
            @Override

            public void onResponse(Call<List<Todo>> call, Response<List<Todo>>
                    response) {
                adapter.addAll(response.body());
                lv.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "valiiiiiiiiide",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error ",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}