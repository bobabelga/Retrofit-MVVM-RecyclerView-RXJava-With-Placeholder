package com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.R;
import com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.pojo.Post;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    ArrayList<Post> postArrayList = new ArrayList<>();
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.userId.setText(postArrayList.get(position).getUserId()+"");
        holder.title.setText(postArrayList.get(position).getTitle());
        holder.body.setText(postArrayList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    public void setPostArrayList(ArrayList<Post> postArrayList) {
        this.postArrayList = postArrayList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView userId,title,body;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
