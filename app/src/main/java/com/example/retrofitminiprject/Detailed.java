package com.example.retrofitminiprject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detailed extends AppCompatActivity {
    ImageView proimg,postimg;
    TextView nick;

    private  JsonPlaceHolder jsonPlaceHolder;
    ArrayAdapter<String> adapter;
    private RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        postimg=findViewById(R.id.postimg_detail);
        proimg=findViewById(R.id.profile_detail_id);
        nick=findViewById(R.id.nickname_detialid);
        rView=(RecyclerView)findViewById(R.id.rv_comment);




        jsonPlaceHolder=APIClient.getRetroClient().create(JsonPlaceHolder.class);
        int ID=getIntent().getIntExtra("Id",0);

        Log.d("in detail", ID + "");

        nick.setText(getIntent().getStringExtra("nicknameDet"));

        String profileImg=getIntent().getStringExtra("PimgDet");
        String postimgdetail=getIntent().getStringExtra("postimg");

        Glide.with(this)
                .load(profileImg)
                .circleCrop()
                .into(proimg);

        Glide.with(this)
                .load(postimgdetail)
                .into(postimg);


        fetchComments(ID);

    }

    private void fetchComments(int id) {
        Call<List<Comments>> comments = jsonPlaceHolder.getComments(id);
        comments.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                List<Comments> comments1 = response.body();


                CommentsAdapter adapter = new CommentsAdapter(Detailed.this,comments1);
                rView.setLayoutManager(new LinearLayoutManager(Detailed.this));
                rView.setAdapter(adapter);
               // rView.setLayoutManager(new LinearLayoutManager(this));



            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

                Toast.makeText(Detailed.this, "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}