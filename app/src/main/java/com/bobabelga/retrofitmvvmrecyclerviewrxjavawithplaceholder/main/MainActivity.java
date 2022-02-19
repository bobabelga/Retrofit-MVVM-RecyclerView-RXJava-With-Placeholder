package com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.R;
import com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.data.PostClient;
import com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.data.PostInterface;
import com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.pojo.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String TAG = "Retrofit Bob";
    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        PostAdapter postAdapter = new PostAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);

        postViewModel =new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getPosts();
        postViewModel.mutablePostLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                postAdapter.setPostArrayList((ArrayList<Post>) posts);
            }
        });

    }
}