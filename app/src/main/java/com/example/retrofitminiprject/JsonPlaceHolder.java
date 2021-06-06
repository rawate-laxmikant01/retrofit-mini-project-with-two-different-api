package com.example.retrofitminiprject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolder {

    @GET("characters")
    Call<List<Posts>> getPosts();

    @GET("comments")
    Call<List<Comments>> getComments(@Query("postId")int id);



}
