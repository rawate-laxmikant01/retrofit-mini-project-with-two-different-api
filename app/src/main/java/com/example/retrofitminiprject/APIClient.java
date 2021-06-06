package com.example.retrofitminiprject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static String BASE_URL="https://www.breakingbadapi.com/api/";
    private static Retrofit retrofit=null;

    private static String BASE_URL_json="https://jsonplaceholder.typicode.com/";
    private static Retrofit retro=null;


    public static Retrofit getRClient(){
        if(retrofit==null){

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
    public static Retrofit getRetroClient(){
        if(retro==null){

            Gson gson = new GsonBuilder()
                    .create();

            retro=new Retrofit.Builder()
                    .baseUrl(BASE_URL_json)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retro;
    }

}
