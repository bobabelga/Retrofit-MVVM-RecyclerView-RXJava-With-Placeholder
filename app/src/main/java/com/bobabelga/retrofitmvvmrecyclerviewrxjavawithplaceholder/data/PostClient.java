package com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.data;

import com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.pojo.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostClient INSTANCE;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostClient getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PostClient();
        }
        return INSTANCE;
    }

    public Observable<List<Post>> getPosts() {
        return postInterface.getPosts();
    }
}
