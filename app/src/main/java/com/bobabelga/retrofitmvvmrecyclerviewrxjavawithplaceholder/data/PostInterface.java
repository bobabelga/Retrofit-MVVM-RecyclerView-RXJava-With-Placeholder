package com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.data;

import com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.pojo.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    Observable<List<Post>> getPosts();
}
