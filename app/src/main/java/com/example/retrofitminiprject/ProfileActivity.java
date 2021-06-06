package com.example.retrofitminiprject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class ProfileActivity extends AppCompatActivity {

    ImageView pimg;
    TextView Name, nickname, birthday, status, portrayed, category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        pimg=findViewById(R.id.profile_detail_img);
        Name=findViewById(R.id.name);
        nickname=findViewById(R.id.nikename);
        birthday=findViewById(R.id.birthday);
        status=findViewById(R.id.status);
        portrayed=findViewById(R.id.portrayed);
        category=findViewById(R.id.category);
//
//        //name, nickname, img, mimage, birthday, occupation, status, portrayed, category
//
        String profieImg=getIntent().getStringExtra("Pimg");


        Name.setText(getIntent().getStringExtra("name"));
        nickname.setText(getIntent().getStringExtra("nickname"));
        birthday.setText(getIntent().getStringExtra("birthday"));
        status.setText(getIntent().getStringExtra("status"));
        portrayed.setText(getIntent().getStringExtra("portrayed"));
        category.setText(getIntent().getStringExtra("category"));




        Glide.with(this)
                .load(profieImg)
                .circleCrop()
                .into(pimg);

    }
}