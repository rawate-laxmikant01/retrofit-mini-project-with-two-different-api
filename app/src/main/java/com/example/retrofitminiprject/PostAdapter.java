package com.example.retrofitminiprject;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>  implements Filterable {

    List<Posts>post;
    Context context;
    List<Posts>allpost;


    public PostAdapter(List<Posts> post, Context context) {
        this.post = post;
        this.context = context;
        this.allpost=new ArrayList<>(post);
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_layout,parent,false);
        PostViewHolder postViewHolder=new PostViewHolder(v);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Posts posts=post.get(position);
        String post_img= "https://source.unsplash.com/random/"+ posts.getChar_id();
        posts.setMimage(post_img);


        holder.Rv_name.setText(posts.getName());
        String img=posts.getImg();
        String imgPost=posts.getMimage();
        Glide.with(context)
                .load(img)
                .circleCrop()
                .into(holder.Rv_profile);

        Glide.with(context)
                .load(imgPost)
                .into(holder.Rv_Post);

        holder.Rv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ProfileActivity.class);
                //name, nickname, img, mimage, birthday, occupation, status, portrayed, category

                intent.putExtra("Pimg",img);
                intent.putExtra("name",posts.getName());
                intent.putExtra("nickname",posts.getNickname());
                intent.putExtra("birthday",posts.getBirthday());
            //    intent.putExtra("occupation",posts.getOccupation());
                intent.putExtra("status",posts.getStatus());
                intent.putExtra("portrayed",posts.getPortrayed());
                intent.putExtra("category",posts.getCategory());



                context.startActivity(intent);

            }
        });

        holder.Rv_Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,Detailed.class);
                intent.putExtra("PimgDet",img);
                intent.putExtra("nicknameDet",posts.getNickname());
                intent.putExtra("postimg",posts.getMimage());

                intent.putExtra("Id",posts.getChar_id());

                Log.d("**",""+posts.getChar_id());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return post.size();
    }

    @Override
    public Filter getFilter() {
        return filter;

    }
    Filter filter=new Filter() {
        //run on background theat
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Posts> filterlist=new ArrayList<>();

            if (constraint.toString().isEmpty()) {
                filterlist.addAll(allpost);

            }else {
                for (Posts post:allpost){
                    if(post.toString().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filterlist.add(post);
                    }
                }
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=filterlist;
            return filterResults;

        }

        //run on ui theat
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            post.clear();
            post.addAll((Collection<? extends Posts>) results.values);
            notifyDataSetChanged();
        }
    };

    public class PostViewHolder extends RecyclerView.ViewHolder {

        ImageView Rv_profile,Rv_Post;
        TextView Rv_name;
        LinearLayout parentLayout;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            Rv_profile=itemView.findViewById(R.id.profile_img_id);
            Rv_name=itemView.findViewById(R.id.name_id);
            Rv_Post=itemView.findViewById(R.id.postimage_id);
            parentLayout=itemView.findViewById(R.id.linear);
        }
    }
}
