package com.example.task;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit {
    private static Retrofit retrofit;
    private static String BASE_URL="https://hacker-news.firebaseio.com/";

    public static Retrofit getRetrofitInstance(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
}}
