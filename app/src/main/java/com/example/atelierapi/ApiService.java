package com.example.atelierapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("todos")
    public Call<List<Todo>> getTodo();

    //@GET("todos/{id}")

    //public Call<List<Todo>> getDataById(@Path("id") Integer id);
}
